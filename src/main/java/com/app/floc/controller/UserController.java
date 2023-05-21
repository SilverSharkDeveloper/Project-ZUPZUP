package com.app.floc.controller;

import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.user.EmailService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    private final UserService userService;
    private final EmailService registerMail;

    //회원가입 폼으로
    @GetMapping("join")
    public void goToJoinForm(UserVO userVO){
    }

    //이메일 중복검사
    @GetMapping("check-email/{email}")
    @ResponseBody
    public boolean checkEmail(@PathVariable String email){return userService.checkId(email).isPresent();}

    //닉네임 중복검사
    @GetMapping("check-nickname/{nickname}")
    @ResponseBody
    public boolean checkNickname(@PathVariable String nickname){return userService.checkNickname(nickname).isPresent();}

    //메일보내기
    @PostMapping("login/mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam("email") String email) throws Exception {
        String code = registerMail.sendSimpleMessage(email);
        return code;
    }
}
