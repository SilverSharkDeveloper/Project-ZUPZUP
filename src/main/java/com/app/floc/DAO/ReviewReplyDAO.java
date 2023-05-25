package com.app.floc.DAO;

import com.app.floc.domain.DTO.ReplyDTO;
import com.app.floc.domain.VO.ReviewReplyVO;
import com.app.floc.mapper.ReviewReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewReplyDAO {
    private final ReviewReplyMapper reviewReplyMapper;

    //    댓글 목록
    public List<ReplyDTO> findAll(Long id){
        return reviewReplyMapper.selectAll(id);
    }

    //    댓글 작성
    public void save(ReviewReplyVO reviewReplyVO){
        reviewReplyMapper.insert(reviewReplyVO);
    }

    //    댓글 수정
    public void setReply(ReplyDTO replyDTO){
        reviewReplyMapper.update(replyDTO);
    }

    //    댓글 삭제
    public void delete(Long id){
        reviewReplyMapper.delete(id);
    }

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long reviewId){
        reviewReplyMapper.deleteAll(reviewId);
    }
}
