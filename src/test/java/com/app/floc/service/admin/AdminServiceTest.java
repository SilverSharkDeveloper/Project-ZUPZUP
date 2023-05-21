package com.app.floc.service.admin;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class AdminServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserListTest(){
//        userService.getUserList().stream().map(UserVO::toString).forEach(log::info);
    }
    @Test
    public void getUserRecent(){
        userService.getUserRecent().stream().map(UserVO::toString).forEach(log::info);
    }



}