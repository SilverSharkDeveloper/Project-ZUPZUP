package com.app.floc.mapper;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    //    공지사항 목록
//    페이징 처리된거. 검색


    public List<NoticeDTO> selectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);
    
    //공지사항 상세보기
     public Optional<NoticeDTO> select(Long id);

    //    공지사항 추가
    public void insert(NoticeDTO noticeDTO);


    //    공지사항 수정
    public void update(NoticeDTO noticeDTO);

    //    공지사항 삭제
    public void delete(Long id);

    //    게시글의 파일 전체 삭제?

    //    게시글 총 개수
    public int selectCountOfNotice(@Param("search") Search search);


}


