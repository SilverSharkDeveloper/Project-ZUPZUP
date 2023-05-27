package com.app.floc.controller;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("notice/*")
public class NoticeController {
    private final NoticeService noticeService;


//    화면에 목록
    @GetMapping("notice")
    public void list(AdminPagination adminPagination, Search search, Model model){
        adminPagination.setTotal(noticeService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("notices", noticeService.getList(adminPagination,search));
    }



    //상세보기
    @GetMapping(value={"notice-detail", "admin/notice-update-form"})
    public void read(Long id, Model model){

        model.addAttribute("notices", noticeService.read(id));
    }
//
//    @PostMapping("modify")
//    public RedirectView modify(NoticeVO noticeVO, RedirectAttributes redirectAttributes){
//        noticeService.modify(noticeVO);
//        redirectAttributes.addAttribute("id",noticeVO.getId())
//        return new RedirectView("admin/notice-form");
//    }
//

}
