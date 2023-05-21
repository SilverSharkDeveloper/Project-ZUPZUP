package com.app.floc.DAO;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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


    //admin
    //회원 정보 조회
    public List<UserVO> findByUser(com.app.floc.domain.DTO.AdminPagination adminPagination, Search search){
        return userMapper.selectAll(adminPagination, search);
    }
    //admin 총명
    //회원 수 조회
    public int findCountOfUser(Search search){
        return userMapper.selectCountOfUser(search);
    };

    //회원 목록 페이징 없이 id순 높은 5개조회
    public List<UserVO> findByRecent(){
        return userMapper.selectByRecent();

    }

}
