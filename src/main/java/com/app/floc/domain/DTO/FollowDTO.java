package com.app.floc.domain.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class FollowDTO {
    private Long id;
    private Long followerId;
    private Long followingId;
    private String followStartDate;
    private String userNickname;
    private String userIntroducingMessage;
    private String profileImageName;
    private Long profileImageSize;
    private String profileImagePath;
}
