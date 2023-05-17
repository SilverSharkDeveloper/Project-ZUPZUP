package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PloggingVO {
    private Long id;
    private Long localCreatorId;
    private String title;
    private String content;
    private String startLocation;
    private String endLocation;
    private String estimatedTime;
    private String startDateTime;
    private String status;
    private String applyDate;
    private String rejectedReason;
    private String registerDate;
    private String updateDate;
    private String reward;
}
