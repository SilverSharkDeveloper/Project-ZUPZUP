package com.app.floc.domain.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class ProductDTO {
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
    private String productImageUuid;
    private Long productImageSize;
    private String productImagePath;

    private Long userWishCount;
    private boolean isWished;
}
