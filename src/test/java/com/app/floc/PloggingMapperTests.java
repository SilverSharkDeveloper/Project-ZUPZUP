package com.app.floc;

import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.mapper.PloggingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PloggingMapperTests {
    @Autowired
    private PloggingMapper plogginMapper;

    @Test
    public void insertTest(){
        PloggingVO ploggingVO = new PloggingVO();
        ploggingVO.setLocalCreatorId(1L);
        ploggingVO.setPloggingTitle("TestTitle1");
        ploggingVO.setPloggingContent("TestContent1");
        ploggingVO.setPloggingStartLocation("");
        ploggingVO.setPloggingEndLocation("");
        ploggingVO.setPloggingEstimatedTime(0);
        ploggingVO.setPloggingMaximumParticipant(0);
        ploggingVO.setPloggingStartDateTime("");
        ploggingVO.setPloggingStatus("estimating");
        ploggingVO.setPloggingRejectedReason("");
        ploggingVO.setPloggingImageName("");
        ploggingVO.setPloggingImageUuid("");
        ploggingVO.setPloggingImageSize(0L);


        plogginMapper.insert(ploggingVO);
    }
}
