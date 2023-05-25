package com.app.floc.controller;

import com.app.floc.domain.DTO.ReplyDTO;
import com.app.floc.domain.VO.ReviewReplyVO;
import com.app.floc.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reviewReplies/*")
public class ReviewReplyController {
    private final ReplyService replyService;


    @PostMapping("write")
    public void write(@RequestBody ReviewReplyVO reviewReplyVO){
        replyService.write(reviewReplyVO);
    }

    @GetMapping("list/{reviewId}")
    public List<ReplyDTO> getList(@PathVariable Long reviewId){
        return replyService.getList(reviewId);
    }

    @PutMapping("modify")
//    @PatchMapping("modify")
    public void modify(@RequestBody ReviewReplyVO reviewReplyVO){
        replyService.modify(reviewReplyVO);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id){
        replyService.remove(id);
    }
}
