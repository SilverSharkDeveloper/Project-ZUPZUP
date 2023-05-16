package com.app.floc.DAO;

import com.app.floc.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponDAO {
    private final CouponMapper couponMapper;
}
