package com.app.floc.mapper;

import com.app.floc.domain.DTO.ReviewDTO;
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
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setUserId(1L);
        reviewDTO.setPloggingId(4L);
        reviewDTO.setReviewTitle("테스트 제목2");
        reviewDTO.setReviewContent("테스트 내용2");
        reviewMapper.insert(reviewDTO);
    }

//    @Test
//    public void selectAllTest() {
//        Pagination pagination = new Pagination(1);
//        pagination.setPage(1); //화면에서 전달받은 페이지
////        assertThat(postMapper.selectAll(pagination)).hasSize(2);
////        postMapper.selectAll(pagination, new Search("popular")).stream().map(PostDTO::toString).forEach(log::info);
//        reviewMapper.selectAll(pagination).stream().map(ReviewDTO::toString).forEach(log::info);
//    }

//    @Test
//    public void selectTest(){
//        reviewMapper.select(23L).map(ReviewDTO::getUserNickname).ifPresent(log::info);
//    }
}