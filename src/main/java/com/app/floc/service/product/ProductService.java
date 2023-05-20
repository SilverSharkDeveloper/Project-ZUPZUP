package com.app.floc.service.product;

import com.app.floc.domain.VO.ProductVO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    //상품등록
    public void register(ProductVO productVO);

    //상품한개조회 -> 화면에서 상세보기
    public Optional<ProductVO> read(Long productId);

    //상품전체조회 -> 목록조회 ->pagination
    public List<ProductVO> getList();

    //상품 제거
    public void remove(Long productId);

}
