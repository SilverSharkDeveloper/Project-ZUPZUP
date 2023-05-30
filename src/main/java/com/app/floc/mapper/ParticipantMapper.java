package com.app.floc.mapper;

import com.app.floc.domain.DTO.*;
import com.app.floc.domain.DTO.ParticipantDTO;
import com.app.floc.domain.VO.ParticipantVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParticipantMapper {
    //  마이페이지 참가자 등록
    public void insert(ParticipantDTO participantDTO);

    //  마이페이지 참가자 목록
    public List<ParticipantDTO> selectAll(MyPloggingPagination myPloggingPagination);

    //  마이페이지 참가자 삭제
    public void delete(Long id);
}
