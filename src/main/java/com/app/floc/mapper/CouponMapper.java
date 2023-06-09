package com.app.floc.mapper;

import com.app.floc.domain.VO.CouponVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CouponMapper {


    //쿠폰 발급
    public void insert(CouponVO couponVO);

    //쿠폰 사용시 valid, 사용날짜 update
    public void update(CouponVO couponVO);

    //쿠폰 한개 가져오기
    public Optional<CouponVO> select(Long couponId);

    //쿠폰 한개 패스로 가져오기
    public Optional<CouponVO> selectByCouponPath(String couponQrcodePath);

    //쿠폰 전체 조회
    public List<CouponVO> selectAll(Long userId);

}
