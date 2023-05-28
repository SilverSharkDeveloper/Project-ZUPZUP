package com.app.floc.mapper;

import com.app.floc.domain.VO.ProductWishVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProductWishMapper {
        //위시 추가
        public void insert(Long userId,Long productId);

        //위시 조회
        public Optional<ProductWishVO> selectOne(Long userId, Long productId);

        //위시 삭제
        public void delete(Long id);

}
