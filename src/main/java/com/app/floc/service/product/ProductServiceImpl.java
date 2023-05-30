package com.app.floc.service.product;

import com.app.floc.DAO.*;
import com.app.floc.domain.DTO.*;
import com.app.floc.domain.VO.*;
import com.app.floc.DAO.ProductDAO;
import com.app.floc.domain.VO.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    private final ProductWishDAO productWishDAO;
    private final UserDAO userDAO;
    private final TissueDAO tissueDAO;
    private final CouponDAO couponDAO;

    @Override
    public void register(ProductVO productVO) {
        productDAO.save(productVO);
    }


    //상품 상세보기
    @Override
    public Optional<ProductDTO> read(Long productId, Long userId) {

        Optional<ProductDTO> foundProduct = productDAO.findByProductId(productId);
        if(userId !=null){
            Optional<ProductWishVO> foundWish = productWishDAO.findOne(userId, productId);
            foundWish.ifPresent(wish -> foundProduct.get().setWished(true));
        }
        return foundProduct;
    }

    //16개씩 가져오기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProductDTO> getList(ProductPagination productPagination,Long userId) {
        List<ProductDTO> productDTOS = productDAO.findSixteenProducts(productPagination);
        if(userId!=null){
            List<Long> allWishProductsByUserId = productDAO.findAllWishProductsByUserId(userId);
            productDTOS.stream().forEach(productDTO -> productDTO.setWished(allWishProductsByUserId.contains(productDTO.getId())));
        }
        return productDTOS;
    }
    //상품제거
    @Override
    public void remove(Long productId) {
        productDAO.delete(productId);
    }


    //위시목록
    @Override
    public void addOrDeleteWish(Long userId, Long productID) {
        Optional<ProductWishVO> foundWish = productWishDAO.findOne(userId, productID);
        if(foundWish.isPresent()){
           productWishDAO.delete(foundWish.get().getId());
        }else{
            productWishDAO.save(userId,productID);
        }

    }


    //상품 구매
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buyProduct(Long userId, Long productId) {
        //유저 티슈 감소
        Optional<UserVO> foundUser = userDAO.findByUserId(userId);
        foundUser.ifPresent(user -> user.setUserTissue(user.getUserTissue()-(productDAO.findByProductId(productId).get().getProductCost())));
        userDAO.setUser(foundUser.get());

        //상품 재고 감소
        productDAO.stockDecrease(productId);

        //티슈 테이블에 히스토리 남기기
        TissueVO tissueVO = new TissueVO();
        tissueVO.setUserId(userId);
        tissueVO.setTissueHistory(productDAO.findByProductId(productId).get().getProductName()+" 쿠폰 구매");
        tissueVO.setTissuePoint(productDAO.findByProductId(productId).get().getProductCost()*(-1));
        tissueDAO.buyProductHistory(tissueVO);

        //쿠폰 밝급 ->qr 생성
        CouponVO couponVO = new CouponVO();
        couponVO.setProductId(productId);
        couponVO.setUserId(userId);
        String uuid = UUID.randomUUID().toString();
        couponVO.setCouponQrcodePath("https://api.qr-code-generator.com/v1/create?access-token=kROO-WIIea6Pba5qQB1smTFioF8VS_kfpY_w9aoEdNnNE8GAS8o0kj5SLXgUlhVn&qr_code_text=http://192.168.0.164:10000/coupon/use-coupon?randomId="+uuid);
        couponDAO.addCoupon(couponVO);







    }


    @Override
    public List<ProductVO> getAdminList(AdminPagination adminPagination, Search search) {
        return productDAO.findAllByAdmin(adminPagination,search);
    }

    @Override
    public int getTotal(Search search) {
        return productDAO.findCountOfProduct(search);
    }

    @Override
    public void deleteProductsByIds(List<Long> productIds) {
        productDAO.deleteProductsByIds(productIds);
    }
////    메인페이지 목록 가져오기
//    @Override
//    public List<ProductVO> getMainList() {
//        return productDAO.findAllByMain();
//    }
}
