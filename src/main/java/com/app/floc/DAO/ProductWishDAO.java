package com.app.floc.DAO;

import com.app.floc.domain.VO.ProductWishVO;
import com.app.floc.mapper.ProductWishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductWishDAO {
    private final ProductWishMapper productWishMapper;
    //위시 추가
    public void save(Long userId,Long productID){
        productWishMapper.insert(userId,productID);
    }

    //위시 조회
    public Optional<ProductWishVO> findOne(Long userId, Long productId){
        return productWishMapper.selectOne(userId,productId);
    }

    //위시 삭제
    public void delete(Long id){
        productWishMapper.delete(id);
    }
}
