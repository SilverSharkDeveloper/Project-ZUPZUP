package com.app.floc.controller;

import com.app.floc.domain.VO.NoticeVO;
import com.app.floc.domain.dto.NoticeDTO;
import com.app.floc.domain.dto.Pagination;
import com.app.floc.domain.dto.Search;
import com.app.floc.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice/*")
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("list")
    public void list(Pagination pagination, Search search, Model model){
        pagination.setTotal(noticeService.getTotal(search));
//        pagination.progress();
        model.addAttribute("notices", noticeService.getList(pagination,search));
    }
    //관리자가 작성
//    @GetMapping("write")
//    public void goToNoticeForm(NoticeVO noticeVO){ ;}
//
//    @PostMapping("write")
//    public RedirectView write(NoticeDTO noticeDTO){
//        noticeService.write(noticeDTO);
//        return new RedirectView("/admin/notice");
//    }



    @GetMapping(value={"read", "modify"})
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
//    @PostMapping("remove")
//    public RedirectView remove(Long id){
//        noticeService.remove(id);
//        return new RedirectView("admin/notice");
//    }
}
