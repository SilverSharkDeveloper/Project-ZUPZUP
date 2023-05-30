package com.app.floc.controller;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.Search;
import com.app.floc.service.plogging.PloggingService;
import com.app.floc.service.product.ProductService;
import com.app.floc.service.review.ReviewService;
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
@RequestMapping("/main/*")
public class MainController {
    private final ReviewService reviewService;
    private final PloggingService ploggingService;
    private final ProductService productService;

    @GetMapping("main")
    public void main(Pagination pagination, Search search, Model model){
//        model.addAttribute("products", productService.getList());
//        model.addAttribute("ploggings", ploggingService.getList(pagination, search));
        model.addAttribute("reviews",reviewService.getList(pagination, search));
    }

    //    파일 업로드
    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadReivewImage") List<MultipartFile> uploadReviewImages) throws IOException {
        String path = "C:/upload/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(path);
        if(!file.exists()){file.mkdirs();}

        for (int i=0; i<uploadReviewImages.size(); i++){
            uuids.add(UUID.randomUUID().toString());
            uploadReviewImages.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadReviewImages.get(i).getOriginalFilename()));
            if(uploadReviewImages.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadReviewImages.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadReviewImages.get(i).getInputStream(), out, 100, 100);
                out.close();
            }
        }
        return uuids;
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    //    상품파일 불러오기
    @GetMapping("displayProduct")
    @ResponseBody
    public byte[] displayProduct(String productFullImageName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", productFullImageName));
    }
    //    파일 불러오기
    @GetMapping("displayPlogging")
    @ResponseBody
    public byte[] displayPlogging(String ploggingFullImageName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", ploggingFullImageName));
    }

    //    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String productFullImageName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + productFullImageName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(productFullImageName.substring(productFullImageName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
