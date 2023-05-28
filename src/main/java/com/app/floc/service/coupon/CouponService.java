package com.app.floc.service.coupon;

import com.app.floc.domain.VO.CouponVO;

import java.util.Optional;

public interface CouponService {
    //쿠폰 한개 가져오기
    public Optional<CouponVO> findOne(Long couponId);

    //쿠폰 발급
    public void addCoupon(CouponVO couponVO);

    //쿠폰 사용시 valid, 사용날짜 update
    public void useCoupon(CouponVO couponVO);


}
