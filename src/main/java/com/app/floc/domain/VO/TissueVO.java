package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class TissueVO {
    private Long id;
    private Long userId;
    private String history;
    private String createdDate;
    private Long point;
}
