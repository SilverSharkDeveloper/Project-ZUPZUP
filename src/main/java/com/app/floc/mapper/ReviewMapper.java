package com.app.floc.mapper;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {
//    플로깅 후기 조회(사용자)

    public List<ReviewDTO> selectAll(@Param("pagination")Pagination pagination, @Param("search")Search search);
    //    플로깅 후기 조회(로컬크리에이터)
    public List<ReviewDTO> selectAllLocal(@Param("pagination")Pagination pagination, @Param("search")Search search);
    //    플로깅 후기 작성
    public void insert(ReviewDTO reviewDTO);
    //    플로깅 후기 조회
    public Optional<ReviewDTO> selectDetail(Long id);
    //    플로깅 후기 수정
    public void update(ReviewDTO reviewDTO);
    //    플로깅 후기 삭제
    public void delete(Long id);
    //    플로깅 후기 갯수
    public int selectCountOfReview(@Param("search") Search search);
}
