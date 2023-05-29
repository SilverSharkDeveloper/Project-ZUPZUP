package com.app.floc.controller;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice/*")
public class NoticeController {
    private final NoticeService noticeService;


//    화면에 목록
    @GetMapping("notice")
    public String list(AdminPagination adminPagination, Search search, Model model){
        adminPagination.setTotal(noticeService.getTotal(search));
        adminPagination.progress();
        log.info("notice들어옴");
        model.addAttribute("notices", noticeService.getList(adminPagination,search));
    return "notice/notice";
    }

    @ResponseBody
    @GetMapping("notice/{page}")
    public List<NoticeDTO> getList(@PathVariable Integer page,Search search){
        final AdminPagination adminPagination = new AdminPagination();
        adminPagination.setPage(page);
        adminPagination.progress();
            log.info(noticeService.getList(adminPagination,search).toString());
        log.info("ajax데이터 요청하는곳 들어옴");
        return noticeService.getList(adminPagination,search);
    }


    //상세보기
    @GetMapping(value={"notice-detail"})
    public void read(@RequestParam Long id, Model model, AdminPagination adminPagination, Search search){
        model.addAttribute("notice",noticeService.read(id).get());
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
