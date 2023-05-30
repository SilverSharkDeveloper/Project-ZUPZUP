package com.app.floc.mapper;

import com.app.floc.DAO.FollowDAO;
import com.app.floc.domain.DTO.FollowDTO;
import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.ParticipantDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    //  마이페이지 팔로잉,팔로워 등록
    public void insert(FollowDTO followDTO);

    //  마이페이지 팔로잉 목록
    public List<FollowDTO> selectAll();

    //  마이페이지 팔로우 목록
    public List<FollowDTO> selectFollowerAll();

    //  마이페이지 팔로잉 삭제
    public void delete(Long id);
}
