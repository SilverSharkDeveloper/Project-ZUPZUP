package com.app.floc.service.user;

import com.app.floc.domain.VO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class LoginServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void joinTest(){
        UserVO userVO = new UserVO();
        userVO.setUserName("허은상");
        userVO.setUserNickname("silvershark");
        userVO.setUserPassword("hes1234");
        userVO.setUserIdentification("hes1234");

        userService.join(userVO);
    }

    @Test
    public void checkIdTest(){
        Optional<UserVO> foundUser = userService.checkId("hes1234");
        assertThat(foundUser.isPresent()).isEqualTo(true);

    }

    @Test
    public void loginTest(){
        Optional<Long> foundUserId = userService.login("hes1234", "hes1234");
        foundUserId.ifPresent(id -> assertThat(id).isEqualTo(21L));
    }

    @Test
    public void getUserTest(){
        Optional<UserVO> foundUser = userService.getUser(21L);
        foundUser.ifPresent(user->assertThat(user.getUserName()).isEqualTo("허은상"));
    }
    
}