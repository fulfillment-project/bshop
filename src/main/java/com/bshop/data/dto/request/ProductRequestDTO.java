package com.bshop.data.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    private Long sellerProductId;
    private Integer quantity;
    private Integer vendorId;
    private String fromDate;
    private String toDate;
    private String keyword;
}
