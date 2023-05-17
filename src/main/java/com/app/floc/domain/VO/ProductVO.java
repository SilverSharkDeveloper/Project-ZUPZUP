package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductVO {
    private Long id;
    private String productName;
    private Long productCost;
    private Long productStock;
    private String productDetail;
    private String registerDate;
    private String updatedDate;
    private String category;
    private String usedLocation;
    private String productImageName;
    private String ProductImageOriginalName;
    private String productImageSize;
}
