package com.app.floc.mapper;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.VO.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ReviewMapperTest {
    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void insertTest(){
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.setUserId(1L);
        reviewVO.setPloggingId(4L);
        reviewVO.setReviewTitle("테스트 제목2");
        reviewVO.setReviewContent("테스트 내용2");
        reviewMapper.insert(reviewVO);
    }

    @Test
    public void selectAllTest() {
        Pagination pagination = new Pagination(3);
        pagination.setPage(1); //화면에서 전달받은 페이지
//        assertThat(postMapper.selectAll(pagination)).hasSize(2);
//        postMapper.selectAll(pagination, new Search("popular")).stream().map(PostDTO::toString).forEach(log::info);
//        postMapper.selectAll(pagination, new Search()).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        reviewMapper.select(23L).map(ReviewDTO::getUserNickname).ifPresent(log::info);
    }
}