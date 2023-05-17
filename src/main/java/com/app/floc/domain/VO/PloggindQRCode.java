package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PloggindQRCode {
    private Long id;
    private Long ploggingId;
    private String type;
    private String code;
    private String codeImage;
    private String createdDate;
    private String validDate;
}
