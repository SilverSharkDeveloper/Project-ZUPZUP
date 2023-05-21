package com.app.floc.service.plogging;

import com.app.floc.DAO.PloggingDAO;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.mapper.PloggingMapper;
import com.app.floc.service.plogging.PloggingService;
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
    public List<PloggingDTO> getList() {
        return ploggingDAO.findAll();
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
}
