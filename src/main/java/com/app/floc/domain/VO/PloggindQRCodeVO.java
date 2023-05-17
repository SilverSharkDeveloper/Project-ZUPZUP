package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PloggindQRCodeVO {
    private Long id;
    private Long ploggingId;
    private String ploggingQrcodeType;
    private String ploggingQrcodeCreatedDate;
    private String ploggingQrcodeName;
    private String ploggingQrcodeUuid;
    private Long ploggingQrcodeSize;
}
