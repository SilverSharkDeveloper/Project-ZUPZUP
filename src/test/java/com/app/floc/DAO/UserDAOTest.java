package com.app.floc.DAO;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserName("허은상");
        userVO.setUserNickname("silvershark");
        userVO.setUserPassword("hes1234");
        userVO.setUserIdentification("hes1234");

        userDAO.save(userVO);
    }

    @Test
    public void selectByUserIdentificationTest(){
        Optional<UserVO> foundUser = userDAO.findByUserIdentification("hes1234");
        assertThat(foundUser.isPresent()).isEqualTo(true);

    }

    @Test
    public void selectByUserIdentificationAndUserPassword(){
        Optional<Long> foundUserId = userDAO.findByUserIdentificationAndUserPassword("hes1234", "hes1234");
        foundUserId.ifPresent(id -> assertThat(id).isEqualTo(21L));
    }

    @Test
    public void selectByUserId(){
        Optional<UserVO> foundUser = userDAO.findByUserId(21L);
        foundUser.ifPresent(user->assertThat(user.getUserName()).isEqualTo("허은상"));
    }
}