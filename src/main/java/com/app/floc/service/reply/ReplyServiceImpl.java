package com.app.floc.service.reply;

import com.app.floc.DAO.ReviewReplyDAO;
import com.app.floc.domain.DTO.ReplyDTO;
import com.app.floc.domain.VO.ReviewReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReviewReplyDAO reviewReplyDAO;
    @Override
    public List<ReplyDTO> getList(Long id) {
        return reviewReplyDAO.findAll(id);
    }

    @Override
    public void write(ReviewReplyVO reviewReplyVO) {
        reviewReplyDAO.save(reviewReplyVO);
    }

    @Override
    public void modify(ReviewReplyVO reviewReplyVO) {
        reviewReplyDAO.setReply(toDTO(reviewReplyVO));
    }

    @Override
    public void remove(Long id) {
        reviewReplyDAO.delete(id);
    }

    @Override
    public void removeAll(Long reviewId) {
        reviewReplyDAO.deleteAll(reviewId);
    }
}
