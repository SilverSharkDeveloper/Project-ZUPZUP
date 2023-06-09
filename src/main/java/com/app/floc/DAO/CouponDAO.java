package com.app.floc.DAO;

import com.app.floc.domain.VO.CouponVO;
import com.app.floc.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponDAO {
    private final CouponMapper couponMapper;


    //쿠폰 발급
    public void addCoupon(CouponVO couponVO){
        couponMapper.insert(couponVO);
    }

    //쿠폰 사용시 valid, 사용날짜 update
    public void setCoupon(CouponVO couponVO){
        couponMapper.update(couponVO);
    }

    //쿠폰 한개 가져오기
    public Optional<CouponVO> select(Long couponId){
        return couponMapper.select(couponId);
    }

    //쿠폰 한개 패스로 가져오기
    public Optional<CouponVO> findOneByCouponPath(String couponQrcodePath){
        return couponMapper.selectByCouponPath(couponQrcodePath);
    }

    //쿠폰 전체 조회
    public List<CouponVO> findAll(Long userId){
        return  couponMapper.selectAll(userId);
    }
}
