package com.app.floc.DAO;

import com.app.floc.mapper.Product_WishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Product_WishDAO {
    private final Product_WishMapper productWishMapper;
}
