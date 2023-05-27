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
    public List<ReviewDTO> selectAll(@Param("pagination") Pagination pagination, @Param("search")Search search);


    public void insert(ReviewDTO reviewDTO);

    public Optional<ReviewDTO> selectDetail(Long id);

    public void update(ReviewDTO reviewDTO);

    public void delete(Long id);

    public int selectCountOfReview(@Param("search") Search search);

    public List<ReviewDTO> selectAllLocal();
}
