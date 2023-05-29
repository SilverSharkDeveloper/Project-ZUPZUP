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
    private String productRegisterDate;
    private String productUpdatedDate;
    private String productCategory;
    private String productUsedLocation;
    private String productImageName;
    private String ProductImageUuid;
    private Long productImageSize;
    private String productImagePath;
}
