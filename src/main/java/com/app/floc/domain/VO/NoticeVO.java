package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class NoticeVO {
    private Long id;
    private Long adminId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeCreatedDate;
    private String noticeUpdatedDate;
    private Long noticeViewedCount;
    private String noticeImageName;
    private String noticeImageUuid;
    private Long noticeImageSize;
}
