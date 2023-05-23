package com.app.floc.service.review;

import com.app.floc.DAO.ReviewDAO;
import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;
    private final ReviewDTO reviewDTO;

    @Override
    public List<ReviewDTO> getList() {
        return reviewDAO.findAll();
    }
    @Override
    public int getTotal() {
        return reviewDAO.findCountOfReview();
    }

    @Override
    public void write(ReviewDTO reviewDTO) {
        reviewDAO.save(reviewDTO);
    }
}
