package com.app.floc.service.plogging;

import com.app.floc.DAO.PloggingDAO;
import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.PloggingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PloggingServiceImpl implements PloggingService {
    private PloggingDAO ploggingDAO;







    // amdin
    @Override
    public List<PloggingDTO> findAllByAdmin(AdminPagination adminPagination, Search search) {
        return ploggingDAO.findAllByAdmin(adminPagination,search);
    }

    @Override
    public int findCountOfPlogging(Search search) {
        return ploggingDAO.findCountOfPlogging(search);
    }

    @Override
    public void removePloggingByIds(List<Long> ploggingIds) {
        ploggingDAO.deletePloggingByIds(ploggingIds);
    }

    @Override
    public List<PloggingVO> findByRecent() {
        return ploggingDAO.findByRecent();
    }

}
