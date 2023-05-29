package com.app.floc.service.coupon;

import com.app.floc.DAO.CouponDAO;
import com.app.floc.domain.VO.CouponVO;
import com.app.floc.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponDAO couponDAO;

    @Override
    public Optional<CouponVO> findOne(Long couponId) {
        return couponDAO.select(couponId);
    }

    @Override
    public void addCoupon(CouponVO couponVO) {
        couponDAO.addCoupon(couponVO);
    }

    @Override
    public void useCoupon(CouponVO couponVO) {
        couponDAO.setCoupon(couponVO);
    }

    @Override
    public Optional<CouponVO> findOneByCouponQrcodePath(String couponQrcodePath) {
        return couponDAO.findOneByCouponPath(couponQrcodePath);
    }

    @Override
    public List<CouponVO> getList(Long userId) {
        return couponDAO.findAll(userId);
    }
}
