package com.app.floc.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Long ploggingId;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdatedDate;
    private String userNickname;
}
