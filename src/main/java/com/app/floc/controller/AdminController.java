package com.app.floc.controller;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;

import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ProductVO;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.admin.AdminService;
import com.app.floc.service.notice.NoticeService;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final NoticeService noticeService;
    private final ProductService productService;
    private final HttpSession session;

    //    admin관리
    @GetMapping("admin")
    public String goToAdmin(UserVO userVO) {
        return "admin/admin";
    }

    //메인     ,상품,유저,플로깅 데이터 가져오기
    @GetMapping("main")
    public String goToMain(UserVO userVO,Model model) {
        List<UserVO> userRecents = userService.getUserRecent();
        model.addAttribute("userRecents", userRecents);
        log.info(String.valueOf(userRecents));
        return "admin/main";
    }


    //회원 관리
    // 목록
    @GetMapping("member")
    public void member(AdminPagination adminPagination, Search search, Model model) {
        adminPagination.setTotal(userService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("members", userService.getUserList(adminPagination,search));
    }

    @ResponseBody
    @GetMapping("member/{page}/{type}/{keyword}")
    public List<UserVO> memberList(@PathVariable Integer page,@PathVariable String type, @PathVariable String keyword,
            AdminPagination adminPagination,Search search,Model model) {
        adminPagination.setTotal(userService.getTotal(search));
        adminPagination.setPage(page);
        adminPagination.progress();
        List<UserVO> users = userService.getUserList(adminPagination, search);
        return users;
    }
    //회원 삭제
    @ResponseBody
    @DeleteMapping("member/delete")
    public ResponseEntity<List<Long>> deleteMembers(@RequestBody List<Long> userIds) {
        // userIds에 해당하는 회원들을 삭제하는 서비스 메서드 호출
        userService.deleteUsersByIds(userIds);

        // 삭제된 회원들 중 첫 번째 회원의 ID를 반환

        // 삭제된 회원의 ID를 응답으로 반환
        return ResponseEntity.ok(userIds);
    }


    //상품 관리
// 목록
    @GetMapping("product")
    public String productList(AdminPagination adminPagination, Search search, Model model) {
        adminPagination.setTotal(productService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("products", productService.getAdminList(adminPagination, search));
        return "/admin/product";
    }

    //상품 등록
    @GetMapping("product-form")
    public String goToProductForm(ProductVO productVO) {
        return "/admin/product-form";
    }
    @PostMapping("product-form")
    public RedirectView productWrite(ProductVO productVO){
        productVO.setProductImageName("s아2이스");
        productVO.setProductImageSize(2L);
        productVO.setProductImageUuid("as2sd");

        productService.register(productVO);
        return new RedirectView("/admin/product");
    }
//상품 삭제
    @ResponseBody
    @DeleteMapping("product/delete")
    public  ResponseEntity<List<Long>> deleteProducts(@RequestBody List<Long> productIds) {
        // 선택된 ID 값을 서비스로 전달하여 삭제 작업 수행
        productService.deleteProductsByIds(productIds);
        return ResponseEntity.ok(productIds);
    }


    //플로깅 목록
    @GetMapping("floging")
    public void goToFloging() {
        ;
    }

    //플로깅 상세보기
    @GetMapping("floging-detail")
    public void goToFlogingDetailFrom() {
    }

    ;

    //플로깅 수락하기
    @GetMapping("floging-estimate")
    public void goToFlogingEstimateForm() {
    }

    ;


    //공지사항 관리
    //목록
    @GetMapping("notice")
    public String noticeList(AdminPagination adminPagination, Search search, Model model) {
        adminPagination.setTotal(noticeService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("notices", noticeService.getList(adminPagination, search));
        return "/admin/notice";
    }

    //작성 페이지
    @GetMapping("notice-form")
    public String goToNoticeForm(NoticeDTO noticeDTO,Model model) {
        model.addAttribute("userIdentification", userService.getUser((Long)session.getAttribute("id)")).get().getUserIdentification());
        return "/admin/notice-form";
    }

    // 작성
    @ResponseBody
    @PostMapping("notice-form")
    public RedirectView noticeWrite(NoticeDTO noticeDTO) {
//        noticeDTO.setAdminId((Long)session.getAttribute("id"));
//        userService.login("1a2k","12341234");
        String uuid = UUID.randomUUID().toString();
        noticeDTO.setNoticeImageUuid(uuid);
        log.info("=------uuid값");
        log.info(noticeDTO.getNoticeImageUuid());
        noticeDTO.setAdminId(2L);


        noticeDTO.setNoticeImageName("d");
        noticeDTO.setNoticeImageSize(22L);

        noticeService.write(noticeDTO);
        return new RedirectView("/admin/notice");
    }

    //상세보기,수정
    @GetMapping (value = {"notice-update-form"})
    public void read(@RequestParam Long id, Model model ,AdminPagination adminPagination, Search search) {
        model.addAttribute("notice", noticeService.read(id).get());
        log.info("수정으로 드렁옴 ");
    }

    //수정 완료
    @PostMapping("notice-update-form")
    public RedirectView noticeModify(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes,Model model) {

        log.info("============수정완료 컨트롤러");
        log.info(noticeDTO.toString());
        noticeService.modify(noticeDTO);
        redirectAttributes.addAttribute("id",noticeDTO.getId());

        log.info(noticeDTO.toString());
        log.info("수정완료 컨트롤러 들어옴?");
        return new RedirectView("/admin/notice");
    }

    @ResponseBody
    @DeleteMapping("notice/delete")
    public ResponseEntity<List<Long>> deleteNotices(@RequestBody List<Long> selectedIds) {
        // 선택된 ID 값을 서비스로 전달하여 삭제 작업 수행
        noticeService.deleteNoticeByIds(selectedIds);
        return ResponseEntity.ok(selectedIds);
    }
    //문의 목록
    @GetMapping("qna")
    public void goToQnaForm() {

    }
}
