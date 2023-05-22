package com.app.floc.mapper;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.VO.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {

    //    후기 목록
    public List<ReviewDTO> selectAll(@Param("pagination") Pagination pagination);

    //    후기 작성
    public void insert(ReviewVO reviewVO);

    //    총 개수
    public int selectTotalCount();

    //    후기 조회
    public Optional<ReviewDTO> select(Long id);

    //    후기 수정
    public void update(ReviewDTO reviewDTO);

    //    후기 삭제
    public void delete(Long id);
}
