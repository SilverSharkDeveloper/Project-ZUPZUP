package com.app.floc.service.review;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ReviewVO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public List<ReviewDTO> getList(Pagination pagination, Search search);

    public void write(ReviewDTO reviewDTO);

    public Optional<ReviewDTO> read(Long id);

    public void modify(ReviewDTO reviewDTO);

    public void remove(Long id);

    public int getTotal(Search search);

    public List<ReviewDTO> getLocalList();

    default ReviewDTO toDTO(ReviewVO reviewVO){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(reviewVO.getId());
        reviewDTO.setReviewTitle(reviewVO.getReviewTitle());
        reviewDTO.setReviewContent(reviewVO.getReviewContent());
        reviewDTO.setUserId(reviewVO.getUserId());
//        reviewDTO.setReviewReadCount(reviewVO.getReviewReadCount());
        reviewDTO.setReviewRegisterDate(reviewVO.getReviewRegisterDate());
        reviewDTO.setReviewUpdatedDate(reviewVO.getReviewUpdatedDate());
        return reviewDTO;
    }
}
