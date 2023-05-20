package com.app.floc.controller;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    @GetMapping("join")
    public void goToJoinForm(UserVO userVO){

    }
}
