package com.app.floc.mapper;

import com.app.floc.domain.DTO.*;
import com.app.floc.domain.VO.PloggingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PloggingMapper {

    //  등록
    public void insert(PloggingVO ploggingVO);

    //  DTO 등록
    public void insertList(PloggingDTO ploggingDTO);

    //  목록
    public List<PloggingDTO> selectAll(Pagination pagination, Search search);

    //  조회
    public Optional<PloggingDTO> selectOne(Long id);

    //  수정
    public void update(PloggingDTO ploggingDTO);

    //  삭제
    public void delete(Long id);

    //  게시글 총 개수
    public int selectCountOfPlogging(@Param("search") Search search);

    //  마이페이지 게시글 목록
    public List<PloggingDTO> selectAll(MyPloggingPagination myPloggingPagination, Search search);

    //  마이페이지 파일 목록
    public List<PloggingDTO> selectFiles(Long id);

    //amdin페이지
    // admin

    //전체 목록 조회 페이징,검색
    public List<PloggingDTO> selectAllByAdmin(@Param("adminPagination") AdminPagination adminPagination, @Param("search") Search search);
    //여러개 삭제
    public void deletePloggingByIds(List<Long> ploggingIds);

    //최근 5개 조회
    public List<PloggingVO> selectByRecent();
}
