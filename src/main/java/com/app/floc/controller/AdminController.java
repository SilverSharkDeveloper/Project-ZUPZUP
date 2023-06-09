package com.app.floc.controller;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ProductVO;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.admin.AdminService;
import com.app.floc.service.notice.NoticeService;
import com.app.floc.service.plogging.PloggingService;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final PloggingService ploggingService;
    private final HttpSession session;

    //    admin관리
    @GetMapping("admin")
    public String goToAdmin(UserVO userVO) {
        return "admin/admin";
    }

    //메인     ,상품,유저,플로깅 데이터 가져오기
    @GetMapping("main")
    public String goToMain(UserVO userVO, Model model) {
        List<UserVO> userRecents = userService.getUserRecent();
        List<NoticeDTO> noticeRecents = noticeService.selectByRecent();
//        List<PloggingDTO> ploggRecents =
        model.addAttribute("noticeRecents", noticeRecents);
        model.addAttribute("userRecents", userRecents);
        log.info(String.valueOf(userRecents));
        return "admin/main";
    }


    //회원 관리
    // 목록
    @GetMapping("member")
    public String member(AdminPagination adminPagination, Search search, Model model) {
        adminPagination.setTotal(userService.getTotal(search));
        adminPagination.progress();
        model.addAttribute("members", userService.getUserList(adminPagination, search));
        return "/admin/member";
    }

    //
    @ResponseBody
    @GetMapping("member/{page}")
    public List<UserVO> memberList(@PathVariable Integer page, Search search, Model model) {
        AdminPagination adminPagination = new AdminPagination();
        adminPagination.setTotal(userService.getTotal(search));
        adminPagination.setPage(page);
        adminPagination.progress();
        log.info("memberAjax요청 들어옴");
        return userService.getUserList(adminPagination, search);
    }


    //회원 삭제
    @ResponseBody
    @DeleteMapping("member/delete")
    public ResponseEntity<List<Long>> deleteMembers(@RequestBody List<Long> userIds) {
        // userIds에 해당하는 회원들을 삭제하는 서비스 메서드 호출
        log.info("회원 삭제");
        userService.deleteUsersByIds(userIds);

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

    @ResponseBody
    @PostMapping("product-form")
    public RedirectView productWrite(ProductVO productVO, @RequestParam(value= "uploadFile",required = false) MultipartFile uploadFile) throws IOException {

        if (!uploadFile.isEmpty()) {
            String pathWithoutC = getPath();
            String path = "C:/upload/" + pathWithoutC;
            String uuid = UUID.randomUUID().toString();
            String originalFilename = uploadFile.getOriginalFilename();
           log.info(originalFilename);

            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            uploadFile.transferTo(new File(path, uuid + "_" + uploadFile.getOriginalFilename()));
            if (uploadFile.getContentType().startsWith("image")) {
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuid + "_" + uploadFile.getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFile.getInputStream(), out, 100, 100);
                out.close();
            }
            productVO.setProductImageUuid(uuid);
            productVO.setProductImageSize(uploadFile.getSize());
            productVO.setProductImageName(originalFilename);
            productVO.setProductImagePath(pathWithoutC);
        } else {
            productVO.setProductImageUuid("");
            productVO.setProductImageSize(0L);
            productVO.setProductImageName("");
            productVO.setProductImagePath("");
        }
            productService.register(productVO);
            return new RedirectView("/admin/product");
        }



    //상품 삭제
    @ResponseBody
    @DeleteMapping("product/delete")
    public ResponseEntity<List<Long>> deleteProducts(@RequestBody List<Long> productIds) {
        // 선택된 ID 값을 서비스로 전달하여 삭제 작업 수행
        productService.deleteProductsByIds(productIds);
        return ResponseEntity.ok(productIds);
    }


    //플로깅 목록
    @GetMapping("floging")
    public String flogging(AdminPagination adminPagination, Search search, Model model) {
        log.info("플로김목록 들어옴");
        adminPagination.setTotal(ploggingService.findCountOfPlogging(search));
        adminPagination.progress();
        model.addAttribute("ploggings", ploggingService.findAllByAdmin(adminPagination, search));
        return "/admin/floging";
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
    public String goToNoticeForm(NoticeDTO noticeDTO, Model model) {
//        model.addAttribute("userIdentification", userService.getUser((Long)session.getAttribute("userId")).get().getUserIdentification());
//        model.addAttribute("userId",userService.getUser((Long)session.getAttribute("userId")).get().getId());
        return "/admin/notice-form";
    }


//    컨트롤러
    @ResponseBody
    @PostMapping("notice-form")
    public RedirectView noticeWrite(NoticeDTO noticeDTO, @RequestParam("uploadFile") MultipartFile uploadFile) throws IOException{
        if (!uploadFile.isEmpty()) {
            String pathWithoutC = getPath();
            String path = "C:/upload/" + pathWithoutC;
            String uuid = UUID.randomUUID().toString();
            String originalFilename = uploadFile.getOriginalFilename();
            log.info(originalFilename);

            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            uploadFile.transferTo(new File(path, uuid + "_" + uploadFile.getOriginalFilename()));
            if (uploadFile.getContentType().startsWith("image")) {
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuid + "_" + uploadFile.getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFile.getInputStream(), out, 100, 100);
                out.close();
            }
            noticeDTO.setNoticeImageUuid(uuid);
            noticeDTO.setNoticeImageSize(uploadFile.getSize());
            noticeDTO.setNoticeImageName(originalFilename);
            noticeDTO.setNoticeImagePath(pathWithoutC);
        } else {
            noticeDTO.setNoticeImageUuid("");
            noticeDTO.setNoticeImagePath("");
            noticeDTO.setNoticeImageSize(0L);
            noticeDTO.setNoticeImageName("");

        }
        log.info(noticeDTO.toString());
        noticeService.write(noticeDTO);
        return new RedirectView("/admin/notice");
    }



    //상세보기,수정
    @GetMapping(value = {"notice-update-form"})
    public void read(@RequestParam Long id, Model model, AdminPagination adminPagination, Search search) {
        model.addAttribute("notice", noticeService.read(id).get());
        Optional<NoticeDTO> foundnotice = noticeService.read(id);
        log.info(String.valueOf(foundnotice.map(NoticeDTO::toString)));
        log.info("수정으로 드렁옴 ");
    }

    //수정 완료
    @ResponseBody
    @PostMapping("notice-update-form")
    public RedirectView noticeModify(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes, Model model) {
        noticeDTO.setAdminId((Long) session.getAttribute("userId"));
        noticeDTO.setUserIdentification("alsl910@nate.com");
        log.info("============수정완료 컨트롤러");
        log.info(noticeDTO.toString());
        noticeService.modify(noticeDTO);
        redirectAttributes.addAttribute("id", noticeDTO.getId());
//        redirectAttributes.addAttribute("adminId",noticeDTO.getAdminId());

        log.info(noticeDTO.toString());
        log.info("수정완료 컨트롤러 들어옴?");
        return new RedirectView("/notice/notice-detail");
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
    public void goToQnaForm(AdminPagination adminPagination, Search search, Model model) {
//        adminPagination.setTotal();
    }

    //    //    파일 업로드
//    @PostMapping("upload")
//    @ResponseBody
//    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
//        String path = "C:/upload/" + getPath();
//        String uuid = UUID.randomUUID().toString();
//        File file = new File(path);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        uploadFile.transferTo(new File(path, uuid + "_" + uploadFile.getOriginalFilename()));
//        if (uploadFile.getContentType().startsWith("image")) {
//            FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuid + "_" + uploadFile.getOriginalFilename()));
//            Thumbnailator.createThumbnail(uploadFile.getInputStream(), out, 100, 100);
//            out.close();
//        }
//        return uuid;
//}
//
    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
//
//    //    파일 불러오기
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }
//
//    //    파일 다운로드
//    @GetMapping
//    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
//        Resource resource = new FileSystemResource("C:/upload/" + fileName);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
//        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
//    }
}
