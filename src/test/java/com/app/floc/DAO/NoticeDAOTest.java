package com.app.floc.mapper;

import com.app.floc.DAO.NoticeDAO;
import com.app.floc.domain.dto.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
class NoticeDAOTest {
    @Autowired
    private NoticeDAO noticeDAO;


//    작성
    @Test
    public void saveTest() {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeImageSize(22L);
        noticeDTO.setNoticeImageUuid("Z");
        noticeDTO.setNoticeImageName("광");
        noticeDTO.setAdminId(1L);
        noticeDTO.setNoticeTitle("다함께");
        noticeDTO.setNoticeContent("차차차");
        noticeDAO.save(noticeDTO);
    }
//
//    @Test
//    public void selectAllTest() {
//        Pagination pagination = new Pagination(1);
//        pagination.setPage(1); //화면에서 전달받은 페이지
////        assertThat(noticeMapper.selectAll(pagination)).hasSize(2);
////        noticeMapper.selectAll(pagination, new Search("t", "공지사항", "recent")).stream().map(NoticeDTO::toString).forEach(log::info);
//        assertThat(noticeMapper.selectAll(pagination)).hasSize(1);
//
//    }

    // 상세보기
    @Test
    public void findByIdTest() {
        noticeDAO.findById(1L).map(NoticeDTO::toString).ifPresent(log::info);
        noticeDAO.findById(6L).map(NoticeDTO::toString).ifPresent(log::info);
    }

    //수정
//    @Test
//    public void setTest(){
//
////        noticeDAO.setNoticeDTO();
//    };
//    //
//    @Test
//    public void deleteTest(){
//        notice.delete(2L);
//        assertThat(noticeMapper.selectAll()).hasSize(1);
//
//    }
//
    @Test
    public void selectCountOfNotice() {
    }
}