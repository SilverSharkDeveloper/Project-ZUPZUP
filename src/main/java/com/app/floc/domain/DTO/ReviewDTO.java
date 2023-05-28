package com.app.floc.domain.DTO;

import com.app.floc.domain.VO.ReviewImageVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Long ploggingId;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdatedDate;
    private String userNickname;
    /*파일 정보가 받아지지 않아 강제로 조인해서 가져오기*/
//    private String reviewImageImageName;
//    private String reviewImageImageUuid;
//    private Long reviewImageImageSize;
    /*파일 정보 가져오기*/
    private List<ReviewImageVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
