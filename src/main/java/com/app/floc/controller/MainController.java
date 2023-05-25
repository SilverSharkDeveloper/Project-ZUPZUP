package com.app.floc.controller;

import com.app.floc.service.plogging.PloggingService;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final ReviewService reviewService;
    private final PloggingService ploggingService;
    private final ProductService productService;

    @GetMapping("main")
    public void main(Model model){
//        model.addAttribute("products", productService.getList());
//        model.addAttribute("ploggings", ploggingService.getList());
//        model.addAttribute("reviews",reviewService.getList());
    }
}
