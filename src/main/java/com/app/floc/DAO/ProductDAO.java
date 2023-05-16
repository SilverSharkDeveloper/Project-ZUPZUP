package com.app.floc.DAO;

import com.app.floc.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;
}
