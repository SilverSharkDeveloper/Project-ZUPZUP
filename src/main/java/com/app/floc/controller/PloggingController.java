package com.app.floc.controller;

import com.app.floc.service.plogging.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/plogging/*")
public class PloggingController {
    private final PloggingService ploggingService;


    //마이페이지에서 작성폼으로 가기 위한 매핑
    @GetMapping("plogging-form")
    public void goToPloggingForm() {;
    }
}
