package com.app.floc.controller;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {
    private final ReviewService reviewService;
    private final HttpSession session;

    @GetMapping("user_review_list")
    public String list(Model model){
        model.addAttribute("reviews", reviewService.getList());
        return "review/user_review_list";
    }
}
