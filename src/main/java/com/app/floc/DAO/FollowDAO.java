package com.app.floc.DAO;

import com.app.floc.domain.DTO.FollowDTO;
import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.ParticipantDTO;
import com.app.floc.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FollowDAO {
    private final FollowMapper followMapper;

    //    팔로잉 목록
    public List<FollowDTO> findMyFollowing(){
        return followMapper.selectAll();
    }

    //    팔로워 목록
    public List<FollowDTO> findMyFollower(){
        return followMapper.selectFollowerAll();
    }
}
