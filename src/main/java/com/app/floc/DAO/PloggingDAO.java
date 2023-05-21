package com.app.floc.DAO;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.mapper.PloggingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PloggingDAO {
    private final PloggingMapper ploggingMapper;

    //등록
    public void save(PloggingVO ploggingVO){
        ploggingMapper.insert(ploggingVO);
    }

    //목록
    public List<PloggingDTO> findAll(){
        return ploggingMapper.selectAll();
    }

    //조회
    public Optional<PloggingDTO> findById(Long id){
        return ploggingMapper.selectOne(id);
    }

    //수정
    public void setPloggingDTO(PloggingDTO ploggingDTO){
        ploggingMapper.update(ploggingDTO);
    }

    //삭제
    public void delete(Long id){
        ploggingMapper.delete(id);
    }
}
