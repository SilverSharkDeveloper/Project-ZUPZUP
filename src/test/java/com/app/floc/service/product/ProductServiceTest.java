package com.app.floc.service.product;

import com.app.floc.domain.VO.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductServiceTest {
   @Autowired
   private ProductService productService;
    //상품등록
    @Test
    public void registerTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductCost(3L);
        productVO.setProductImageName("이미지1");
        productVO.setProductDetail("가평에서만 먹을 수 있는 가평 잣 라떼");
        productVO.setProductImageSize(12314L);
        productVO.setProductImageUuid(UUID.randomUUID().toString());
        productVO.setProductName("가평 잣 라떼");
        productVO.setProductStock(3L);
        productVO.setProductUsedLocation("강원도 가평 전지역 가평카페");
        productVO.setProductCategory("음료");

        productService.register(productVO);
    }

    //상품한개조회 -> 화면에서 상세보기
    @Test
    public void readTest(){
        Optional<ProductVO> foundProduct = productService.read(7L);
        assertThat(foundProduct.isPresent()).isEqualTo(true);

    }

    //상품전체조회 -> 목록조회 ->pagination
    @Test
    public void getListTest(){
        List<ProductVO> foundproducts = productService.getList();
        foundproducts.stream().map(ProductVO::toString).forEach(log::info);
        assertThat(foundproducts).hasSize(1);

    }

    //상품 제거
    @Test
    public void remove(){
        productService.remove(5L);
        assertThat(productService.read(5L).isPresent()).isEqualTo(false);
    }

}