package com.app.floc.service.user;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.UserVO;

import java.util.List;
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

    //회원 목록 조회
    public List<UserVO> getUserList(AdminPagination adminPagination, Search search);

    //회원 총 명
    public int getTotal(Search search);

    //최근 5명 조회
    public List<UserVO> getUserRecent();
}
