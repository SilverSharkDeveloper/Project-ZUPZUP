package com.app.floc.DAO;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final NoticeMapper noticeMapper;

    //공지사항 목록
    public List<NoticeDTO> findAll(AdminPagination adminPagination, Search search) {
        return noticeMapper.selectAll(adminPagination, search);
    }

    //    공지사항 상세보기
    public Optional<NoticeDTO> findById(Long id){
        return noticeMapper.select(id);
    }

    //    공지사항 등록
    public void save(NoticeDTO noticeDTO){
            noticeDTO.setAdminId(81L);
            noticeMapper.insert(noticeDTO); };


    //    공지사항 수정
    public void setNoticeDTO(NoticeDTO noticeDTO){
        noticeMapper.update(noticeDTO);
    }

    //    공지사항 삭제
    public void delete(Long id){
        noticeMapper.delete(id);
    }


    // 공지사항 총 개수
    public int findCountOfNotice(Search search){
        return noticeMapper.selectCountOfNotice(search);
    }

    public void deleteNoticeByIds(List<Long> noticeIds){

        noticeMapper.deleteNoticeByIds(noticeIds);
    }

    //    조회수
    public void updateReadCount(Long id){
        noticeMapper.updateReadCount(id);
    }

    public List<NoticeDTO> selectByRecent(){
     return noticeMapper.selectByRecent();
    }
}



