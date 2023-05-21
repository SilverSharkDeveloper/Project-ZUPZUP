package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String userIdentification;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userIntroducingMessage;
    private String userStatus;
    private String userCreatedDate;
    private String userUpdatedDate;
    private String userRole;
    private Long userTissue;
    private String profileImageName;
    private String profileImageUuid;
    private Long profileImageSize;

}
