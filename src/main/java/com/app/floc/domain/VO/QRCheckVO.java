package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class QRCheckVO {
    private Long id;
    private Long ploggingQRCodeId;
    private Long userId;
}
