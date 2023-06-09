package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class CouponVO {

    private Long id;
    private Long userId;
    private Long productId;
    private String couponCreatedDate;
    private String couponUsedDate;
    private String couponStatus;
    private String couponQrcodePath;

}
