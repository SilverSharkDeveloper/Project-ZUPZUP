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
    private final HttpSession session;
// 후기 목록 가져오기 및 총 개수 가져오기
    @GetMapping("user_review_list")
    public void list(Pagination pagination, Search search, Model model){
        pagination.setTotal(reviewService.getTotal(search));
        pagination.progress();
        model.addAttribute("reviews", reviewService.getList(pagination, search));
    }

//    @GetMapping("write")
//    public void goToWriteForm(ReviewVO reviewVO, Model model){
////        model.addAttribute("userNickName", LoginService.getUser((Long)session.getAttribute("id")).get().getUserNickName());
//    }
//
//    @PostMapping("write")
//    public RedirectView write(ReviewDTO reviewDTO){
//        reviewDTO.setUserId((Long)session.getAttribute("id"));
//        reviewService.write(reviewDTO);
//        return new RedirectView("/review/user_review_list");
//    }
    
    @GetMapping("user_review_detail")
    public void reviewRead(Long id, Model model){
        model.addAttribute("reviews", reviewService.read(id).get());
    }

    @PostMapping("modify")
    public RedirectView modify(ReviewDTO reviewDTO, RedirectAttributes redirectAttributes){
        reviewService.modify(reviewDTO);
        redirectAttributes.addAttribute("id", reviewDTO.getId());
        return new RedirectView("/review/local_review_detail");
    }

    @PostMapping("remove")
    public RedirectView remove(Long id){
        reviewService.remove(id);
        return new RedirectView("/review/user_review_list");
    }
    
    @GetMapping("local_review_list")
    public void creatorList(Pagination pagination, Search search, Model model){
        pagination.setTotal(reviewService.getTotal(search));
        pagination.progress();
        model.addAttribute("reviews", reviewService.getLocalList(pagination, search));
    }

//    @GetMapping("user_review_detail")
//    public void userList(Pagination pagination, Search search, Model model){
//        pagination.setTotal(reviewService.getTotal(search));
//        pagination.progress();
//        model.addAttribute("reviews", reviewService.getList(pagination, search));
//    }


    //마이페이지에서 작성폼으로 가기 위한 매핑
    @GetMapping("review-form")
    public void review() {

    }
}
