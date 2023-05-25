package com.app.floc.DAO;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    private final ReviewMapper reviewMapper;

    public List<ReviewDTO> findAll(Pagination pagination, Search search) {
        return reviewMapper.selectAll(pagination, search);
    }

    public void save(ReviewDTO reviewDTO){
        reviewMapper.insert(reviewDTO);
    }

    public Optional<ReviewDTO> findDetail(Long id) {
        return reviewMapper.selectDetail(id);
    }

    public void setReviewDTO(ReviewDTO reviewDTO){
        reviewMapper.update(reviewDTO);
    }

    public void delete(Long id){
        reviewMapper.delete(id);
    }

    public int findCountOfReview(Search search) {
        return reviewMapper.selectCountOfReview(search);
    }

    public List<ReviewDTO> findAllLocal() {
        return reviewMapper.selectAllLocal();
    }
}
