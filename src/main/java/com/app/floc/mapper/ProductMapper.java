package com.app.floc.mapper;

import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.domain.VO.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {
    //상품등록
    public void insert(ProductVO productVO);

    //상품한개조회 -> 화면에서 상세보기
    public Optional<ProductVO> selectOneByProductId(Long productId);

    //상품전체조회 -> 목록조회 ->pagination,위시까지 보이게하기
    public List<ProductDTO> selectSixteen(ProductPagination productPagination);

    //유저아이디로 위시누른 상품id 다가져오기
    public List<Long> selectAllWishProductsByUserId(Long userId);

    //상품 제거
    public void delete(Long productId);


}
