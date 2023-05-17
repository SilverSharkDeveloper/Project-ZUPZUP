package com.app.floc.DAO;

import com.app.floc.mapper.ProductWishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductWishDAO {
    private final ProductWishMapper productWishMapper;
}
