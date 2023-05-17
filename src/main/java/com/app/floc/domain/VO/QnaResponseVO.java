package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class QnaResponseVO {
    private Long id;
    private Long adminId;
    private Long qnaId;
    private String qnaResponseContent;
    private String qnaResponseCreatedDate;
    private String qnaResponseUpdatedDate;
}
