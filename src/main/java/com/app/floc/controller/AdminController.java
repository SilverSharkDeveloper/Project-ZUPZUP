package com.app.floc.controller;

import com.app.floc.domain.VO.NoticeVO;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.domain.dto.NoticeDTO;
import com.app.floc.domain.dto.Pagination;
import com.app.floc.domain.dto.Search;
import com.app.floc.service.admin.AdminService;
import com.app.floc.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final NoticeService noticeService;

//    admin관리
    @GetMapping("admin")
    public void goToAdmin(UserVO userVO){;}



//메인     ,
    @GetMapping("main")
    public void goToMain(Model model){;}

//회원 관리

//상품 관리
    @GetMapping("product")
    public void goToProduct(Model model){;}
//상품 등록
    @GetMapping("product-form")
    public void goToProductForm(Model model){;}

//플로깅 목록

//공지사항
    //목록
    @GetMapping("notice")
    public void goToNotice(int page, Search search, Model model){
        final Pagination pagination = new Pagination();
        pagination.setPage(page);
        model.addAttribute("notices", noticeService.getList(pagination, search));
    }
    //작성 페이지
    @GetMapping("notice-form")
    public void goToNoticeForm(NoticeVO noticeVO){;}

    @PostMapping("notice-form")
    public RedirectView noticeWrite(NoticeDTO noticeDTO){
        noticeService.write(noticeDTO);
        return new RedirectView("/notice");
    }

    //상세보기,수정
    @GetMapping(value = {"notice/read","notice-update-form"})
    public void read(Long id, Model model){
     model.addAttribute("notice", noticeService.read(id));
    }
    //수정 완료
    @PostMapping("notice-update-form")
    public RedirectView noticeModify(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) {
        noticeService.modify(noticeDTO);
        redirectAttributes.addAttribute("id", noticeDTO.getId());
        return new RedirectView("/notice");
    }
    //삭제
    @PostMapping("notice/remove")
    public RedirectView remove(Long id){
        noticeService.remove(id);
        return new RedirectView("/notice");
    }

    //문의 목록
}
