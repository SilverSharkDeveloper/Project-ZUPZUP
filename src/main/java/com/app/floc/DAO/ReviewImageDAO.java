package com.app.floc.DAO;

import com.app.floc.domain.VO.ReviewImageVO;
import com.app.floc.mapper.ReviewImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewImageDAO {
    private final ReviewImageMapper reviewImageMapper;

    //    파일 추가
    public void save(ReviewImageVO reviewImageVO) {
        reviewImageMapper.insert(reviewImageVO);
    }

    //    파일 삭제
    public void delete(Long id) {
        reviewImageMapper.delete(id);
    }

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long reviewId) {
        reviewImageMapper.deleteAll(reviewId);
    }

    //    파일 조회
    public List<ReviewImageVO> findAll(Long reviewId) {
        return reviewImageMapper.selectAll(reviewId);
    }
}
