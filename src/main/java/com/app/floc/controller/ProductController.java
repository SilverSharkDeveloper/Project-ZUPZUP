package com.app.floc.controller;

import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.ProductPagination;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

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

    //상세보기
    @GetMapping("/product-detail")
    public void goToProductDetail(Long productId, HttpSession session, Model model){
        model.addAttribute("productDTO",productService.read(productId,session.getAttribute("userId")==null? null:(Long)session.getAttribute("userId")).get());
    }

    //쿠폰 교환 버튼 클릭
    @ResponseBody
    @GetMapping("/coupon")
    public String exchangeCoupon(Long productId,HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        //로그인 안했을시
        if(userId==null){
            return "noUserId";
        }
        //재고가 없을시
        if(productService.read(productId,userId).get().getProductStock()<=0){
            return "noProductStock";
        }

        //티슈가 부족할시
        Long userTissue = userService.getUser(userId).get().getUserTissue();
        if(productService.read(productId,userId).get().getProductCost()>userTissue){
            return "notEnoughTissue";
        }

        //모든 조건 통과시 쿠폰발급,티슈 사용,-> 유저티슈 감소, 티슈 히스토리 인서트, 쿠폰추가 , product 재고감소
        productService.buyProduct(userId,productId);
        return "success";
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
