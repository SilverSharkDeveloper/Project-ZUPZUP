package com.app.floc.controller;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.service.plogging.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/plogging/*")
public class PloggingController {
    private final PloggingService ploggingService;

    @GetMapping("write")
    public void goToWriteForm(PloggingVO ploggingVO){;}

    @PostMapping("write")
    public RedirectView write(PloggingVO ploggingVO){
        ploggingService.write(ploggingVO);
        return new RedirectView("plogging/plogging");
    }

    @GetMapping("plogging")
    public void list(Model model, @RequestParam(value = "location",required = false) String location){
        model.addAttribute("ploggings",ploggingService.getList(location));
    }

    @GetMapping("plogging-detail")
    public void read(Long id, Model model){
        model.addAttribute("plogging",ploggingService.read(id).get());
    }

    @PostMapping("remove")
    public RedirectView remove(Long id){
        ploggingService.remove(id);
        return new RedirectView("/plogging/plogging");
    }
}
