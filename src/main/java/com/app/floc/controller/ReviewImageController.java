package com.app.floc.controller;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/reviewImage/*")
public class ReviewImageController {
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

    //    파일 불러오기
//    @GetMapping("display")
//    @ResponseBody
//    public byte[] display(String reviewImageName) throws IOException{
//        return FileCopyUtils.copyToByteArray(new File("C:/upload/", reviewImageName));
//    }


    @GetMapping("display")
    @ResponseBody
    public ResponseEntity<Resource> display(String reviewImageName) throws IOException {
        String filePath = "C:/upload/" + reviewImageName;
        File file = new File(filePath);
        Resource resource = new InputStreamResource(new FileInputStream(file));

        // 파일 확장자 추출
        Path path = Paths.get(filePath);
        String extension = Files.probeContentType(path);

        // 적절한 MediaType 설정
        MediaType mediaType;
        if (extension != null) {
            mediaType = MediaType.parseMediaType(extension);
        } else {
            // 기본적으로 이미지 파일로 처리
            mediaType = MediaType.IMAGE_JPEG;
        }

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(mediaType)
                .body(resource);
    }



    //    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String reviewImageName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + reviewImageName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(reviewImageName.substring(reviewImageName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }


}
