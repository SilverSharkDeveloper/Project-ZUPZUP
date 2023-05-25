package com.app.floc.mapper;

import com.app.floc.domain.DTO.ReplyDTO;
import com.app.floc.domain.VO.ReviewReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewReplyMapper {
    //    댓글 목록
    public List<ReplyDTO> selectAll(@Param("id") Long id);

    //    댓글 작성
    public void insert(ReviewReplyVO reviewReplyVO);

    //    댓글 수정
    public void update(ReplyDTO replyDTO);

    //    댓글 삭제
    public void delete(Long id);

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long postId);
}
