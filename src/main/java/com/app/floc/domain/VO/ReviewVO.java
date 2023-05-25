package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ReviewVO {
    private Long id;
    private Long userId;
    private Long ploggingId;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdatedDate;
}
