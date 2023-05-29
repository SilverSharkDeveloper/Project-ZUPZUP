package com.app.floc.service.plogging;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.PloggingPagination;
import com.app.floc.domain.VO.PloggingVO;

import java.util.List;
import java.util.Optional;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.PloggingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PloggingService {



    //등록
    public void write(PloggingVO ploggingVO);

    //목록
    public List<PloggingDTO> getList(String location);

    //조회
    public Optional<PloggingDTO> read(Long id);

    //수정
    public void modify(PloggingDTO ploggingDTO);

    //삭제
    public void remove(Long id);

    public int getTotal(String location);


    //전체 목록 조회 페이징,검색
    public List<PloggingDTO> findAllByAdmin(AdminPagination adminPagination,Search search);
    //총 개수
    public int findCountOfPlogging (Search search);

    //여러개 삭제
    public void removePloggingByIds(List<Long> ploggingIds);

    //최근 5개 조회
    public List<PloggingVO> findByRecent();
}

