package com.bshop.data.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopOrderRequestDTO {
    private Integer orderId;
    private Integer vendorId;
    private String trakingNumber;
    private Long sellerProductId;
    private String sellerProductName;
    private Integer customId;
    private String customName;
    private Integer buyProductCount;
    private Integer salePrice;
    private Integer totalPrice;
    private String phoneNumber;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String memo;
    private String deliveryStatus;
    private String fromDate;
    private String toDate;
    private String orderCheck = "F";
}
