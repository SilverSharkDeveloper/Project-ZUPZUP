package com.app.floc.mapper;

import com.app.floc.domain.DTO.LocalReviewDTO;
import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {
    //    후기 목록
    public List<LocalReviewDTO> selectAll(@Param("myPloggingPagination") MyPloggingPagination myPloggingPagination, @Param("search")Search search);

    //    후기 추가
    public void insert(LocalReviewDTO localReviewDTO);

    //    후기 조회
    public Optional<LocalReviewDTO> select(Long id);

    //    후기 수정
    public void update(LocalReviewDTO localReviewDTO);

    //    후기 삭제
    public void delete(Long id);

    //    후기 총 개수
    public int selectCountOfLocalReview(@Param("search") Search search);
}
