package com.app.floc.controller;

import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.admin.AdminService;
import com.app.floc.service.notice.NoticeService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final NoticeService noticeService;


//    admin관리
    @GetMapping("admin")
    public String goToAdmin(UserVO userVO) {
    return "admin/admin";
    }

//메인     ,상품,유저,플로깅 데이터 가져오기
    @GetMapping("main")
    public void goToMain(UserVO userVO, Model model){
        model.addAttribute("users",userService.getUserRecent());
    }


//회원 관리
// 목록
    @GetMapping("member")
    public void list(AdminPagination adminPagination, Search search, Model model){
        adminPagination.setTotal(userService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("members", userService.getUserList(adminPagination,search));
    }
//회원 삭제

//상품 관리
// 목록
    @GetMapping("product")
    public void goToProduct(Model model){;}
//상품 등록
    @GetMapping("product-form")
    public void goToProductForm(Model model){;}
//상품 삭제


//플로깅 목록
    @GetMapping("floging")
    public void goToFloging(){ ;
    }
    //플로깅 상세보기
    @GetMapping("floging-detail")
    public void goToFlogingDetailFrom(){};
    //플로깅 수락하기
    @GetMapping("floging-estimate")
    public void goToFlogingEstimateForm(){};


//공지사항 관리
    //목록
    @GetMapping("notice")
    public void noticeList(AdminPagination adminPagination, Search search, Model model){
        adminPagination.setTotal(noticeService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("notices", noticeService.getList(adminPagination,search));
    }
    //작성 페이지
    @GetMapping("notice-form")
    public String goToNoticeForm(NoticeDTO noticeDTO){
        return "admin/notice-form";
    }
    // 작성
    @PostMapping("notice-form")
    public RedirectView noticeWrite(NoticeDTO noticeDTO){
//        userService.login("1a2k","12341234");
        noticeDTO.setAdminId(2L);
        noticeDTO.setNoticeImageName("d");
        noticeDTO.setNoticeImageSize(22L);
        noticeDTO.setNoticeImageUuid("1a@");
        noticeService.write(noticeDTO);
        return new RedirectView("notice");
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
    @DeleteMapping
    public RedirectView remove(Long id){
        noticeService.remove(id);
        return new RedirectView("/notice");
    }

    //문의 목록
    @GetMapping("qna")
    public void goToQnaForm(){

    }
}
