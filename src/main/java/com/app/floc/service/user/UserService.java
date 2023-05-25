package com.app.floc.service.user;

import com.app.floc.domain.VO.UserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface UserService {
    //회원가입
    public void join(UserVO userVO);

    //id중복검사
    public Optional<UserVO> checkId(String identification);

    //로그인
    public Optional<Long> login(String userIdentification, String userPassword);

    //userid로 회원 조회
    public Optional<UserVO> getUser(Long userId);

    //닉네임 중복검사
    public Optional<UserVO> checkNickname(String nickname);

    //회원정보 모두수정 VO받기
    public void modifyUser(UserVO userVO);

}
