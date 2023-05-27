package com.app.floc;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.mapper.PloggingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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
        ploggingVO.setPloggingStartLocation("Start Location");
        ploggingVO.setPloggingEndLocation("End Location");
        ploggingVO.setPloggingEstimatedTime(0);
        ploggingVO.setPloggingMaximumParticipant(0);
        ploggingVO.setPloggingStartDateTime("2023-05-20");
        ploggingVO.setPloggingStatus("estimating");
        ploggingVO.setPloggingRejectedReason("Reason");
        ploggingVO.setPloggingImageName("");
        ploggingVO.setPloggingImageUuid("");
        ploggingVO.setPloggingImageSize(0L);


        plogginMapper.insert(ploggingVO);
    }

    @Test
    public void selectAllTest(){
//        assertThat(plogginMapper.selectAll()).hasSize(1);
    }

    @Test
    public void selectOneTest(){
        plogginMapper.selectOne(1L).map(PloggingDTO::getUserNickname).ifPresent(log::info);
    }

    @Test
    public void updateTest(){
        plogginMapper.selectOne(4L).ifPresent(ploggingDTO ->{
            ploggingDTO.setPloggingContent("update test content");
            plogginMapper.update(ploggingDTO);
        });
    }

    @Test
    public void deleteTest() {
        plogginMapper.delete(4L);
    }
}
