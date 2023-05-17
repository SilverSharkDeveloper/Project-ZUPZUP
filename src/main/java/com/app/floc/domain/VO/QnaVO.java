package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class QnaVO {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String createdDate;
    private String updatedDate;
    private String responseStatus;
}
