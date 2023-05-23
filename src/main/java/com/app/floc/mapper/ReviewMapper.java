package com.app.floc.mapper;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {
    public void insert(ReviewDTO reviewDTO);

    public int selectCountOfReview();

    public List<ReviewDTO> selectAll();

}
