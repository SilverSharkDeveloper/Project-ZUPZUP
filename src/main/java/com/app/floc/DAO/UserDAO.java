package com.app.floc.DAO;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    //회원가입
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

    //id중복검사
    public Optional<UserVO> findByUserIdentification(String identification){
       return userMapper.selectByUserIdentification(identification);
    }

    //로그인
    public Optional<Long> findByUserIdentificationAndUserPassword(String userIdentification,String userPassword){
       return userMapper.selectByUserIdentificationAndUserPassword(userIdentification,userPassword);
    }

    //userid로 회원 조회
    public Optional<UserVO> findByUserId(Long userId){
        return userMapper.selectByUserId(userId);
    }


    //닉네임 중복검사
    public Optional<UserVO> findByUserNickname(String nickname){
        return userMapper.selectByUserNickname(nickname);
    }
}
