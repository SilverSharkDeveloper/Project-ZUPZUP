package com.app.floc.controller;

import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.TissueVO;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final MypageService mypageService;


    @GetMapping("my-point")
    public void userPoint(MyPloggingPagination myPloggingPagination, Search search, Model model){
        myPloggingPagination.setTotal(mypageService.getTotal(search));
        myPloggingPagination.progress();
        model.addAttribute("tissues", mypageService.getListPoint(myPloggingPagination, search));
    }

    @GetMapping("users-edit")
    public void userEdit(UserVO userVO){
        mypageService.modifyUser(userVO);
    }

    @GetMapping("users-edit-password")
    public void userEditPassword(UserVO userVO){
        mypageService.modifyPassword(userVO);
    }

    @GetMapping("my-host-list")
    public void list(MyPloggingPagination myPloggingPagination, Search search, Model model){
        myPloggingPagination.setTotal(mypageService.getTotal(search));
        myPloggingPagination.progress();
        model.addAttribute("ploggings", mypageService.getList(myPloggingPagination, search));
    }

    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        String path = "C:/upload/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(path);
        if(!file.exists()){file.mkdirs();}

        for (int i=0; i<uploadFiles.size(); i++){
            uuids.add(UUID.randomUUID().toString());
            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
            if(uploadFiles.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
                out.close();
            }
        }
        return uuids;
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    //    파일 불러오기
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }

    //    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @GetMapping("my-user-review")
    public void review(){

    }
}
