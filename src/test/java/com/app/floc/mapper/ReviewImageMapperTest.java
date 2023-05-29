package com.app.floc.mapper;

import com.app.floc.domain.ReviewImageType.ReviewImageType;
import com.app.floc.domain.VO.ReviewImageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
@Slf4j
@SpringBootTest
class ReviewImageMapperTest {

    @Autowired
    private ReviewImageMapper reviewImageMapper;

    @Test
    public void insertTest(){
        ReviewImageVO reviewImageVO = new ReviewImageVO();
        reviewImageVO.setReviewImageName("김인진짱.png");
        reviewImageVO.setReviewImageSize(1231231L);
        reviewImageVO.setReviewImageUuid(UUID.randomUUID().toString());
        reviewImageVO.setReviewImagePath("2023/05/18");
        reviewImageVO.setReviewId(23L);
        reviewImageMapper.insert(reviewImageVO);
    }

    @Test
    public void selectAllTest(){
        reviewImageMapper.selectAll(23L).stream().map(ReviewImageVO::getReviewImagePath).forEach(log::info);
    }
}