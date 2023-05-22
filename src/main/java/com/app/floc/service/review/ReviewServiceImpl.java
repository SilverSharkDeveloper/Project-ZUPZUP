package com.app.floc.service.review;

import com.app.floc.DAO.ReviewDAO;
import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.VO.ReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;

    @Override
    public void write(ReviewVO reviewVO) {
        reviewDAO.save(reviewVO);
    }

    @Override
    public List<ReviewDTO> getList(Pagination pagination) {
        return reviewDAO.findAll(pagination);
    }

    @Override
    public int total() {
        return reviewDAO.totalCount();
    }

    @Override
    public Optional<ReviewDTO> read(Long id) {
        final Optional<ReviewDTO> foundReview = reviewDAO.find(id);
        return foundReview;
    }

    @Override
    public void modify(ReviewDTO reviewDTO) {
        reviewDAO.update(reviewDTO);
    }

    @Override
    public void remove(Long id) {
        reviewDAO.delete(id);
    }
}
