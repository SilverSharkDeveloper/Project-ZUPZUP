package com.app.floc.controller;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.VO.ReviewVO;
import com.app.floc.service.login.LoginService;
import com.app.floc.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("list")
    public void list(Pagination pagination, Model model){
        pagination.setTotal(reviewService.total());
        model.addAttribute("reviews", reviewService.getList(pagination));
    }

    /*@GetMapping("write")
    public void goToWriteForm(ReviewDTO reviewDTO, HttpSession session, Model model){
        model.addAttribute("nickname", loginService.getId((Long)session.getAttribute("id")).get().getNickname());
    }*/

    @PostMapping("write")
    public RedirectView write(ReviewVO reviewVO){
        reviewService.write(reviewVO);
        return new RedirectView("/review/list");
    }

    @GetMapping(value = {"read", "modify"})
    public void read(Long id, Model model){
        model.addAttribute("review", reviewService.read(id));
    }
    @PostMapping("modify")
    public RedirectView modify(ReviewDTO reviewDTO, RedirectAttributes redirectAttributes){
        reviewService.modify(reviewDTO);
        redirectAttributes.addAttribute("id", reviewDTO.getId());
        return new RedirectView("/review/read");
    }

    @GetMapping("remove")
    public RedirectView remove(Long id){
        reviewService.remove(id);
        return new RedirectView("/review/list");
    }
}
