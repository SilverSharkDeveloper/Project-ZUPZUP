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
    private String ploggingTitle;
    private String ploggingContent;
    private String ploggingStartLocation;
    private String ploggingEndLocation;
    private String ploggingEstimatedTime;
    private String ploggingStartDateTime;
    private String ploggingStatus;
    private String ploggingApplyDate;
    private String ploggingRejectedReason;
    private String ploggingRegisterDate;
    private String ploggingUpdateDate;
    private String ploggingReward;
    private String ploggingImageName;
    private String ploggingImageUuid;
    private Long ploggingImageSize;
}
