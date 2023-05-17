package com.app.floc.controller;

import com.app.floc.service.inter.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final MypageService mypageService;
}
