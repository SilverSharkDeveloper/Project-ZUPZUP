package com.app.floc.DAO;

import com.app.floc.domain.DTO.*;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.domain.DTO.PloggingDTO;
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
    public List<PloggingDTO> findAll(String location){
        return ploggingMapper.selectAll(location);
    }

    //조회
    //    게시글 목록
    public List<PloggingDTO> findAll(Pagination pagination, Search search){
        return ploggingMapper.selectAll(pagination, search);
    }

    //    마이페이지 게시글 목록
    public List<PloggingDTO> findMyAll(MyPloggingPagination myPloggingPagination, Search search){
        return ploggingMapper.selectAll(myPloggingPagination, search);
    }

    //    게시글 추가
    public void save(PloggingDTO ploggingDTO){
        ploggingMapper.insertList(ploggingDTO);
    }

    //    게시글 조회
    public Optional<PloggingDTO> findById(Long id){
        return ploggingMapper.selectOne(id);
    }

    //수정
    //    게시글 수정
    public void setPloggingDTO(PloggingDTO ploggingDTO){
        ploggingMapper.update(ploggingDTO);
    }

    //삭제
    public void delete(Long id){
        ploggingMapper.delete(id);
    }

    //    게시글 총 개수
    public int findCountOfPlogging(Search search){
        return ploggingMapper.selectCountOfPlogging(search);
    }

    public List<PloggingDTO> findFiles(Long ploggingId){
        return ploggingMapper.selectFiles(ploggingId);
    }

    public int getTotal(String location) {
        return ploggingMapper.getTotal(location);
    }
}
