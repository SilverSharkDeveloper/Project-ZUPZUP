package com.app.floc.domain.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@Slf4j
public class ParticipantDTO {
    private Long id;
    private Long localCreatorId;
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
    private String ploggingReward;
    private String ploggingImageName;
    private String ploggingImageUuid;
    private Long ploggingImageSize;
    private Long ploggingId;
    private Long userId;
}
