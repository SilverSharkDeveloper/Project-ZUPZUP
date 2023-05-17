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
    private String reviewImageName;
    private String reviewImageUuid;
    private Long reviewImageSize;
}
