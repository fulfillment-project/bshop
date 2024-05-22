package com.bshop.data.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerProductId;

    private String sellerProductName;

    private String content;

    private Integer vendorId;

    private Integer salePrice;

    private Integer quantity;

    private Integer maxBuyCount;

    private String brand;

    private String image;

    private Integer deliveryCharge;

    private String connectCheck;
}
