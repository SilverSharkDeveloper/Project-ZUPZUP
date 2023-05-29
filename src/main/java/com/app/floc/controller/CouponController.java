package com.app.floc.controller;


import com.app.floc.DAO.CouponDAO;
import com.app.floc.domain.VO.CouponVO;
import com.app.floc.service.coupon.CouponService;
import com.app.floc.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/coupon/*")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;
    private final ProductService productService;


    //마이페이지에서 qrcode 누르면 이동
    @GetMapping("qrcode")
    public RedirectView qrCode(Long couponId){
        Optional<CouponVO> foundCoupon = couponService.findOne(couponId);
        String path ="";
        path = foundCoupon.get().getCouponQrcodePath() +"?couponId=" + couponId;
        log.info(path);
        return new RedirectView(path);
    }

    //qrcode 체크히면 확인할 수 있는 버튼으로 이동
    @GetMapping("use-coupon")
    public void useCoupon(Long couponId, Model model){

        model.addAttribute("product",productService.read(couponService.findOne(couponId).get().getProductId(),null).get());
        model.addAttribute("coupon",couponService.findOne(couponId).get());

    }

    //확인 또는 취소눌렀을떄 실행될 ajax
    @ResponseBody
    @GetMapping("check-coupon")
    public boolean checkCoupon(String check, Long couponId){
        log.info(check);
        log.info(couponId.toString());
        if(check.equals("true")){
            Optional<CouponVO> foundCoupon = couponService.findOne(couponId);
            foundCoupon.ifPresent(couponVO -> couponService.useCoupon(couponVO));
            return true;
        }else{

            return false;
        }

    }

}
