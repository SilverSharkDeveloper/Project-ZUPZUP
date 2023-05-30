package com.app.floc.DAO;

import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.ParticipantDTO;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.mapper.ParticipantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipantDAO {
    private final ParticipantMapper participantMapper;

    //    마이페이지 게시글 목록
    public List<ParticipantDTO> findMyAll(MyPloggingPagination myPloggingPagination){
        return participantMapper.selectAll(myPloggingPagination);
    }
}
