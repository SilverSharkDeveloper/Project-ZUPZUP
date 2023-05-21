package com.app.floc.service.plogging;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;

import java.util.List;
import java.util.Optional;

public interface PloggingService {
    //등록
    public void write(PloggingVO ploggingVO);

    //목록
    public List<PloggingDTO> getList();

    //조회
    public Optional<PloggingDTO> read(Long id);

    //수정
    public void modify(PloggingDTO ploggingDTO);

    //삭제
    public void remove(Long id);

}
