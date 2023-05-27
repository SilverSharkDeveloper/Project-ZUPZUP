package com.app.floc.controller;

import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product-list")
    public void goToProductList(){

    }
    //16개씩 리스트뽑는 ajax
    @ResponseBody
    @GetMapping("/getList")
    public List<ProductDTO> getSixteenList(ProductPagination productPagination, HttpSession session){
        log.info(productPagination.toString());
      return productService.getList(productPagination,session.getAttribute("userId")!=null ? (Long)session.getAttribute("userId"):null);
    }


    @GetMapping("/product-detail")
    public void goToProductDetail(){

    }

    //위시리스트 ajax
    @ResponseBody
    @GetMapping("/wishing")
    public Long wishing(Long productId,HttpSession session){
        log.info(productId.toString());
        if(session.getAttribute("userId")==null){
            return null;
        }

        productService.addOrDeleteWish((Long)session.getAttribute("userId"),productId);
        return (Long)session.getAttribute("userId");
    }
}
