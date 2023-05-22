package com.app.floc.service.review;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.VO.ReviewVO;
import org.apache.ibatis.annotations.Param;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    //    후기 작성
    public void write(ReviewVO reviewVO);
    //    후기 목록
    public List<ReviewDTO> getList(Pagination pagination);
    //    총 개수
    public int total();
    //    후기 조회
    public Optional<ReviewDTO> read(Long id);
    //    후기 수정
    public void modify(ReviewDTO reviewDTO);
    //    후기 삭제
    public void remove(Long id);

    default ReviewDTO toDTO(ReviewVO reviewVO){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(reviewVO.getId());
        reviewDTO.setPloggingId(reviewVO.getPloggingId());
        reviewDTO.setReviewTitle(reviewVO.getReviewTitle());
        reviewDTO.setReviewContent(reviewVO.getReviewContent());
        reviewDTO.setReviewRegisterDate(reviewVO.getReviewRegisterDate());
        reviewDTO.setReviewUpdatedDate(reviewVO.getReviewUpdateDate());
        reviewDTO.setUserId(reviewVO.getUserId());
        return reviewDTO;
    }
}
