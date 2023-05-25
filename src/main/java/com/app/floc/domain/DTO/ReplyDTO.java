package com.app.floc.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyDTO {
    private Long id;
    private Long reviewId;
    private Long userId;
    private String replyContent;
    private String replyRegisterDate;
    private String replyUpdatedDate;
    private String userNickname;
}
