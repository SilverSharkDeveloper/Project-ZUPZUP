package com.app.floc.controller;

import com.app.floc.DAO.ParticipantDAO;
import com.app.floc.FlocApplication;
import com.app.floc.domain.DTO.*;
import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.ProductDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.CouponVO;
import com.app.floc.domain.VO.ProductVO;
import com.app.floc.domain.VO.TissueVO;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.coupon.CouponService;
import com.app.floc.service.mypage.MypageService;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import java.io.UnsupportedEncodingException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final MypageService mypageService;
    private final CouponService couponService;
    private final ProductService productService;
    private final UserService userService;
    private final HttpSession session;



    @GetMapping("my-point")
    public void userPoint(MyPloggingPagination myPloggingPagination, Search search, Model model) {
        TissueVO tissueVO = new TissueVO();
        tissueVO.setUserId((Long)session.getAttribute("id"));
        myPloggingPagination.setTotal(mypageService.getTotal(search));
        myPloggingPagination.progress();
        model.addAttribute("tissues", mypageService.getListPoint(myPloggingPagination, search));
    }

    @GetMapping("users-edit")
    public void userEdit() {
        ;
    }

    @GetMapping("users-edit-password")
    public void viewPassword() {;
    }

    @PostMapping("users-edit-password")
    public RedirectView userEditPassword(@Param("password") String password, String identification, UserVO userVO) {

        /*userVO.setId((Long)session.getAttribute("id"));
        userVO.setUserPassword(password);
        mypageService.modifyPassword(userVO);*/
        return new RedirectView("/mypage/main");
    }

    @PostMapping("user-exit")
    public RedirectView remove(Long id) {
        mypageService.exitUser(id);
        return new RedirectView("/user/login");
    }

    @GetMapping("my-host-list")
    public void list(MyPloggingPagination myPloggingPagination, Search search, Model model) {
        PloggingDTO ploggingDTO = new PloggingDTO();
        ploggingDTO.setLocalCreatorId((Long)session.getAttribute("id"));
        myPloggingPagination.setTotal(mypageService.getTotal(search));
        myPloggingPagination.progress();
        model.addAttribute("ploggings", mypageService.getList(myPloggingPagination, search));
    }

    @GetMapping("my-participate-list")
    public void participantList(MyPloggingPagination myPloggingPagination, Model model) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setUserId((Long)session.getAttribute("id"));
        myPloggingPagination.progress();
        model.addAttribute("ploggings", mypageService.getParticipantList(myPloggingPagination));
    }


    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        String path = "C:/upload/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (int i = 0; i < uploadFiles.size(); i++) {
            uuids.add(UUID.randomUUID().toString());
            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
            if (uploadFiles.get(i).getContentType().startsWith("image")) {
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
                out.close();
            }
        }
        return uuids;
    }

    public String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    //    파일 불러오기
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }

    //    파일 다운로드
   /* @GetMapping
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }*/


    @GetMapping("my-local-review")
    public void Localreview(Pagination pagination, Search search, Model model) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId((Long)session.getAttribute("id"));
        pagination.progress();
        model.addAttribute("reviews", mypageService.getListLocal(pagination, search));
    }

    @GetMapping("my-user-review")
    public void UserReview(Pagination pagination, Search search, Model model) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setUserId((Long)session.getAttribute("userId"));
        pagination.progress();
        model.addAttribute("reviews", mypageService.getListUser(pagination, search));
    }

    @GetMapping("my-follower")
    public void Follower(Model model){
        model.addAttribute("follows", mypageService.getListFollower());

    }

    @GetMapping("my-following")
    public void Follow(Model model){
        model.addAttribute("follows", mypageService.getListFollowing());
    }

    @GetMapping("main")
    public void goToMain(Model model) {
        model.addAttribute("nickname",userService.getUser((Long)session.getAttribute("userId")).get().getUserNickname());
        if(userService.getUser((Long)session.getAttribute("userId")).get().getProfileImagePath() != null){
            model.addAttribute("profile",userService.getUser((Long)session.getAttribute("userId")).get().getProfileImagePath());
        }
    }

    //쿠폰 목록으로 가기
    @GetMapping("my-product")
    public void goToProduct(Model model) {
        List<CouponVO> coupons = couponService.getList((Long) session.getAttribute("userId"));
        List<ProductDTO> products = new ArrayList<>();
        coupons.stream().forEach(couponVO -> products.add(
                productService.read(
                        couponVO.getProductId(),(Long)session.getAttribute("userId")
                ).get()
        ));

        log.info(coupons.toString());
        log.info(products.toString());

        model.addAttribute("coupons",coupons);
        model.addAttribute("products",products);

    }

    @GetMapping("mypage-cute")
    public void goToCute() {;
    }


}
