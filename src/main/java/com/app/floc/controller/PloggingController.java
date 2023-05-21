package com.app.floc.controller;

import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.VO.PloggingVO;
import com.app.floc.service.plogging.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return new RedirectView("/plogging/list");
    }

    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("ploggings",ploggingService.getList());
    }

    @GetMapping(value = {"read", "modify"})
    public void read(Long id, Model model){
        model.addAttribute("post",ploggingService.read(id));
    }

    @PostMapping("modify")
    public RedirectView modify(PloggingDTO ploggingDTO, RedirectAttributes redirectAttributes) {
        ploggingService.modify(ploggingDTO);
        redirectAttributes.addAttribute("id",ploggingDTO.getId());
        return new RedirectView("/plogging/read");
    }

    @PostMapping("remove")
    public RedirectView remove(Long id){
        ploggingService.remove(id);
        return new RedirectView("/plogging/list");
    }
}
