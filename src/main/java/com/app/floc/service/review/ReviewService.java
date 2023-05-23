package com.app.floc.service.review;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.ReviewVO;
import org.apache.ibatis.annotations.Param;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    //    후기 작성
    public void write(ReviewDTO reviewDTO);

    //게시글 전체갯수 조회
    public int getTotal();

    //    후기 조회
    public List<ReviewDTO> getList();

}
