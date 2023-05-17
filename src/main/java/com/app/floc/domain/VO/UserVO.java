package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String identification;
    private String password;
    private String name;
    private String phoneNumber;
    private String nickname;
    private String birthday;
    private String introducingMessage;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String role;
    private String profileImageName;
    private String profileImageOriginalName;
    private String profileImageSize;

}
