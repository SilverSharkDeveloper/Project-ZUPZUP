package com.app.floc.mapper;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    //회원가입
    public void insert(UserVO userVO);

    //id중복검사
    public Optional<UserVO> selectByUserIdentification(String identification);

    //로그인
    @Select("SELECT ID FROM TBL_USER WHERE USER_IDENTIFICATION = #{userIdentification} AND USER_PASSWORD = #{userPassword}")
    public Optional<Long> selectByUserIdentificationAndUserPassword(
            @Param("userIdentification") String userIdentification, @Param("userPassword") String userPassword
    );

    //userid로 회원 조회
    public Optional<UserVO> selectByUserId(Long userId);

    //닉네임 중복검사
    public Optional<UserVO> selectByUserNickname(String nickname);

    //회원정보 모두수정 VO받기
    public void updateUser(UserVO userVO);
    //회원정보,페이징 조회


    public List<UserVO> selectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search") Search search);

    //총 개수
    public int selectCountOfUser(@Param("search") Search search);

    //어드민 메인 페이징없이조회
    public List<UserVO> selectByRecent();

    //회원정보수정
    public void update(UserVO userVO);

    //비밀번호 수정
    public void updatePassword(UserVO userVO);

    //회원탈퇴
    public void delete(UserVO userVO);
}
