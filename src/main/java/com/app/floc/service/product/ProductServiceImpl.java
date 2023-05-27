package com.app.floc.service.product;

import com.app.floc.DAO.ProductDAO;
import com.app.floc.DAO.ProductWishDAO;
import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.domain.VO.ProductVO;
import com.app.floc.domain.VO.ProductWishVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    private final ProductWishDAO productWishDAO;

    @Override
    public void register(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public Optional<ProductVO> read(Long productId) {
        return productDAO.findByProductId(productId);
    }

    //16개씩 가져오기
    @Override
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


}
