package com.bshop.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ShopOrder extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer vendorId;

    private Long sellerProductId;

    private String sellerProductName;

    private Integer customId;

    private String customName;

    private Integer buyProductCount;

    private Integer salePrice;

    private Integer totalPrice;

    @Column(length = 30)
    private String phoneNumber;

    private String zipCode;

    private String address;

    private String addressDetail;

    private String memo;

    private String trakingNumber;

    private String deliveryStatus;

    private String orderCheck;
}
