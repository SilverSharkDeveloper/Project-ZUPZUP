package com.app.floc.DAO;

import com.app.floc.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private static UserMapper userMapper;



    //    회원정보 수정
    public static void updateUserDTO(UserEditDTO userEditDTO){
        userMapper.updateUser(userEditDTO);
    }

}
