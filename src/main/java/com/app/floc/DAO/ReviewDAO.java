package com.app.floc.DAO;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
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
    public void save(ReviewVO reviewVO){
        reviewMapper.insert(reviewVO);
    };
    //    후기 목록
    public List<ReviewDTO> findAll(Pagination pagination){
        return reviewMapper.selectAll(pagination);
    };
    //    총 개수
    public int totalCount(){
        return reviewMapper.selectTotalCount();
    };
    //    후기 조회
    public Optional<ReviewDTO> find(Long id){
        return reviewMapper.select(id);
    };
    //    후기 수정
    public void update(ReviewDTO reviewDTO){
        reviewMapper.update(reviewDTO);
    };
    //    후기 삭제
    public void delete(Long id){
        reviewMapper.delete(id);
    };
}
