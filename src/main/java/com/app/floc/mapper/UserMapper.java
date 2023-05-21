package com.app.floc.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //  회원정보 수정
    public void updateUser(UserEditDTO userEditDTO);
}
