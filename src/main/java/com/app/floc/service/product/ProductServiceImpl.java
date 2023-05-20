package com.app.floc.service.product;

import com.app.floc.DAO.ProductDAO;
import com.app.floc.domain.VO.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public void register(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public Optional<ProductVO> read(Long productId) {
        return productDAO.findByProductId(productId);
    }

    @Override
    public List<ProductVO> getList() {
        return productDAO.findAll();
    }

    @Override
    public void remove(Long productId) {
        productDAO.delete(productId);
    }
}
