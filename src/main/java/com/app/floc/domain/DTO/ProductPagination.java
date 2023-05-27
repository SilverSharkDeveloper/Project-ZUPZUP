package com.app.floc.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductPagination {
    private String order;
    private String category;
    private String location;
    private Long count;
}
