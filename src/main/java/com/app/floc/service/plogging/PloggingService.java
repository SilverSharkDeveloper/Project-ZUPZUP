package com.app.floc.service.plogging;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.PloggingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PloggingService {




    //전체 목록 조회 페이징,검색
    public List<PloggingDTO> findAllByAdmin(AdminPagination adminPagination,Search search);
    //총 개수
    public int findCountOfPlogging (Search search);

    //여러개 삭제
    public void removePloggingByIds(List<Long> ploggingIds);

    //최근 5개 조회
    public List<PloggingVO> findByRecent();
}

