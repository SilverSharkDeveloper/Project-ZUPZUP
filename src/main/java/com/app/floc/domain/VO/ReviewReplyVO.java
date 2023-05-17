package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ReviewReplyVO {
    private Long id;
    private Long reviewId;
    private Long userId;
    private String content;
    private String registerDate;
    private String updatedDate;
}
