package com.app.floc.service.plogging;

import com.app.floc.DAO.PloggingDAO;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.PloggingPagination;
import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.PloggingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PloggingServiceImpl implements PloggingService {
    private final PloggingDAO ploggingDAO;

    @Override
    public void write(PloggingVO ploggingVO) {
        ploggingDAO.save(ploggingVO);
    }

    @Override
    public List<PloggingDTO> getList(String location) {
        return ploggingDAO.findAll(location);
    }

    @Override
    public Optional<PloggingDTO> read(Long id) {
        return ploggingDAO.findById(id);
    }

    @Override
    public void modify(PloggingDTO ploggingDTO) {

        ploggingDAO.setPloggingDTO(ploggingDTO);
    }

    @Override
    public void remove(Long id) {
        ploggingDAO.delete(id);
    }

    @Override
    public int getTotal(String location) {
        return ploggingDAO.getTotal(location);
    }


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
