package com.app.floc.mapper;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PloggingMapper {
    //등록
    public void insert(PloggingVO ploggingVO);

    //목록
    public List<PloggingDTO> selectAll();

    //조회
    public Optional<PloggingDTO> selectOne(Long id);

    //수정
    public void update(PloggingDTO ploggingDTO);

    //삭제
    public void delete(Long id);
}
