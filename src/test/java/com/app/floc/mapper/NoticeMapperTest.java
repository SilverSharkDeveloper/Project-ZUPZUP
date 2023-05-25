package com.app.floc.mapper;

import com.app.floc.domain.DTO.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;


@SpringBootTest
@Slf4j
class NoticeMapperTest {
    @Autowired
    private NoticeMapper noticeMapper;

    //작성
    @Test
    public void insertTest() {
        NoticeDTO noticeDTO = new NoticeDTO();

        noticeDTO.setAdminId(1L);
        noticeDTO.setNoticeImageName("아이스크림.png");
        noticeDTO.setNoticeImageSize(1231231L);
        noticeDTO.setNoticeImageUuid(UUID.randomUUID().toString());
        noticeDTO.setNoticeTitle("공지사항 제목 3");
        noticeDTO.setNoticeContent("공지사항ㄴ 3용 ");
//        noticeDTO.setNoticeViewedCount(1L);
        noticeMapper.insert(noticeDTO);
    }
    //상세보기
    @Test
    public void selectTest(){
        Optional<NoticeDTO> foundNotice = noticeMapper.select(4L);
        foundNotice.ifPresent(notice -> assertThat(notice.getNoticeTitle()).isEqualTo("공지사항 제목 3"));
        foundNotice.stream().map(NoticeDTO::toString).forEach(log::info);
    }


    //전체 조회  / 페이징처리, 검색
//    @Test
//    public void selectAllTest() {
//        Pagination pagination = new Pagination();
//        pagination.setPage(1);
//        assertThat(noticeMapper.selectAll(1L,pagination)).hasSize(2);
//    }
//        assertThat(noticeMapper.selectAll(pagination,search)).hasSize();
//        noticeMapper.selectAll(new Pagination(), new Search()).stream().map(NoticeDTO::toString).forEach(log::info);
    //수정
    //삭제
    //게시글 총 개수
}


//@Test
//    public void selectAllTest(){
//        assertThat(replyMapper.selectAll(1L)).hasSize(2);
//    }
//
//    @Test
//    public void updateTest(){
//        final ReplyVO replyVO = replyMapper.selectAll(1L).get(0);
//        replyVO.setReplyContent("수정된 내용");
//        replyMapper.update(replyVO);
//
//        assertThat(replyMapper.selectAll(1L).get(0).getReplyContent()).isEqualTo("수정된 내용");
//    }
//
//    @Test
//    public void deleteTest(){
//        IntStream.rangeClosed(2, 3).forEach(i -> replyMapper.delete(Long.valueOf(i)));
//    }
//
//    @Test
//    public void deleteAllTest(){
//        replyMapper.deleteAll(1L);
//    }