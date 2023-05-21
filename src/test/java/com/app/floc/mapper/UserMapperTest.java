package com.app.floc.mapper;

import com.app.floc.domain.VO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.PushBuilder;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {
    @Autowired
    private  UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserName("허은상");
        userVO.setUserNickname("silvershark");
        userVO.setUserPassword("hes1234");
        userVO.setUserIdentification("hes1234");

        userMapper.insert(userVO);
    }

    @Test
    public void selectByUserIdentificationTest(){
        Optional<UserVO> foundUser = userMapper.selectByUserIdentification("hes1234");
        assertThat(foundUser.isPresent()).isEqualTo(true);

    }

    @Test
    public void selectByUserIdentificationAndUserPasswordTest(){
        Optional<Long> foundUserId = userMapper.selectByUserIdentificationAndUserPassword("hes1234", "hes1234");
       foundUserId.ifPresent(id -> assertThat(id).isEqualTo(21L));
    }

    @Test
    public void selectByUserIdTest(){
        Optional<UserVO> foundUser = userMapper.selectByUserId(21L);
        foundUser.ifPresent(user->assertThat(user.getUserName()).isEqualTo("허은상"));

    }
    @Test
    public void selectAll(){
//        final Optional<UserVO> foundAll = userMapper.selectAll();
//        userMapper.selectAll().stream().map(UserVO::toString).forEach(log::info);

//        assertThat(noticeMapper.selectAll(1L,pagination)).hasSize(2);
    }
}