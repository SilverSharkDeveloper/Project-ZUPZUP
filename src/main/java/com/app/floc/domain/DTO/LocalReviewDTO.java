package com.app.floc.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LocalReviewDTO {
    private Long id;
    private Long userId;
    private Long ploggingId;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdateDate;
    private String userNickname;
    private Long localCreatorId;

}
