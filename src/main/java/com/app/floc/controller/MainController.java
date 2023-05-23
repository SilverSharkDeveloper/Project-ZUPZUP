package com.app.floc.controller;

import com.app.floc.service.main.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final MainService mainService;

    @GetMapping("main")
    public String main(){
        return ("main/main");
    }
}
