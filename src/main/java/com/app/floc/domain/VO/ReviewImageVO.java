package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ReviewImageVO {
    private Long id;
    private Long reviewId;
    private String reviewImagePath;
    private String reviewImageImageName;
    private String reviewImageImageUuid;
    private Long reviewImageImageSize;
    private String reviewImageType;
}
