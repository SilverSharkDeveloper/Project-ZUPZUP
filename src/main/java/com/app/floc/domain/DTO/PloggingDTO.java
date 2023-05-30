package com.app.floc.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class PloggingDTO {
    private Long id;
    private Long localCreatorId;
    private String userNickname;
    private String ploggingTitle;
    private String ploggingContent;
    private String ploggingStartLocation;
    private String ploggingEndLocation;
    private int ploggingEstimatedTime;
    private int ploggingMaximumParticipant;
    private String ploggingStartDateTime;
    private String ploggingStatus;
    private String ploggingApplyDate;
    private String ploggingRejectedReason;
    private String ploggingRegisterDate;
    private String ploggingUpdateDate;
    private String ploggingViewedCount;
    private String ploggingReward;
    private String ploggingImageName;
    private String ploggingImageUuid;
    private Long ploggingImageSize;

}
