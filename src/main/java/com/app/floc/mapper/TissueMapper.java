package com.app.floc.mapper;

import com.app.floc.domain.VO.TissueVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TissueMapper {
    //    포인트 목록
    public List<TissueVO> selectAll(@Param("pagination") Pagination pagination);

    //    포인트 추가
    public void insert(TissueVO tissueVO);

    //    포인트 삭제
    public void delete(Long id);

}
