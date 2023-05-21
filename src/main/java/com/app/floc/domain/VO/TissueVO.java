package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@Slf4j
public class TissueVO {
    private Long id;
    private Long userId;
    private String tissueHistory;
    private String tissueCreatedDate;
    private Long tissuePoint;
}
