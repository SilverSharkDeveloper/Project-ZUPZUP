package com.app.floc.mapper;

import com.app.floc.domain.VO.ReviewImageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewImageMapper {
    //    파일 추가
    public void insert(ReviewImageVO reviewImageVO);

    //    파일 삭제
    public void delete(Long id);

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long reviewId);

    //    파일 조회
    public List<ReviewImageVO> selectAll(Long reviewId);
}
