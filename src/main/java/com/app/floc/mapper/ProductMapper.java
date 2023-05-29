package com.app.floc.mapper;

import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {
    //상품등록
    public void insert(ProductVO productVO);

    //상품한개조회 -> 화면에서 상세보기
    public Optional<ProductDTO> selectOneByProductId(Long productId);

    //상품전체조회 -> 목록조회 ->pagination,위시까지 보이게하기
    public List<ProductDTO> selectSixteen(ProductPagination productPagination);

    //유저아이디로 위시누른 상품id 다가져오기
    public List<Long> selectAllWishProductsByUserId(Long userId);

    //상품 제거
    public void delete(Long productId);

    //재고감소
    public void decrease(Long productId);
    //admin 상품 전체 조회 페이징 처리
    public List<ProductVO> selectAllByAdmin(AdminPagination adminPagination, Search search);

    //admin 상품 총 개수
    public int selectCountOfProduct(@Param("search") Search search);

    //admin 삭제
    public void deleteProductsByIds(List<Long> productIds);


}
