package com.app.floc.DAO;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ReviewVO;
import com.app.floc.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    private final ReviewMapper reviewMapper;
    //    후기 작성
    public void save(ReviewDTO reviewDTO){
        reviewMapper.insert(reviewDTO);
    }

    public int findCountOfReview() {
        return reviewMapper.selectCountOfReview();
    }

    public List<ReviewDTO> findAll() {
        return reviewMapper.selectAll();
    }
}
