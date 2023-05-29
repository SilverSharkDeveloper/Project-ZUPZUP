package com.app.floc.service.reply;

import com.app.floc.domain.DTO.ReplyDTO;
import com.app.floc.domain.VO.ReviewReplyVO;

import java.util.List;

public interface ReplyService {
    //    댓글 목록
    public List<ReplyDTO> getList(Long id);

    //    댓글 작성
    public void write(ReviewReplyVO reviewReplyVO);

    //    댓글 수정
    public void modify(ReviewReplyVO reviewReplyVO);

    //    댓글 삭제
    public void remove(Long id);

    //    게시글의 댓글 전체 삭제
    public void removeAll(Long reviewId);

    default ReplyDTO toDTO(ReviewReplyVO reviewReplyVO){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setId(reviewReplyVO.getId());
        replyDTO.setUserId(reviewReplyVO.getUserId());
        replyDTO.setReplyContent(reviewReplyVO.getReplyContent());
        replyDTO.setReviewId(reviewReplyVO.getReviewId());
        replyDTO.setReplyRegisterDate(reviewReplyVO.getReplyRegisterDate());
        replyDTO.setReplyUpdatedDate(reviewReplyVO.getReplyUpdatedDate());
        return replyDTO;
    }
}
