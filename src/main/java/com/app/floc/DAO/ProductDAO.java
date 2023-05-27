package com.app.floc.DAO;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.domain.VO.ProductVO;
import com.app.floc.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    //상품등록
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }

    //상품한개조회 -> 화면에서 상세보기
    public Optional<ProductVO> findByProductId(Long productId){
        return productMapper.selectOneByProductId(productId);
    }

    //상품전체조회 -> 목록조회 ->pagination
    public List<ProductDTO> findSixteenProducts(ProductPagination productPagination){
        return productMapper.selectSixteen(productPagination);
    }

    //유저아이디로 위시누른 상품id 다가져오기
    public List<Long> findAllWishProductsByUserId(Long userId){
        return productMapper.selectAllWishProductsByUserId(userId);
    }


    //상품 제거
    public void delete(Long productId){
        productMapper.delete(productId);
    }

}
