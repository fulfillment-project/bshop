package com.bshop.data.dto.response;

import com.bshop.data.entity.ShopOrder;
import com.bshop.util.MethodUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopOrderResponseDTO {
    private Integer orderId;
    private Long sellerProductId;
    private String sellerProductName;
    private Integer customId;
    private String customName;
    private Integer vendorId;
    private Integer buyProductCount;
    private Integer salePrice;
    private Integer totalPrice;
    private String phoneNumber;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String memo;
    private String deliveryStatus;
    private String insertDateTime;
    private String updateDateTime;

    public ShopOrderResponseDTO fromOrder(ShopOrder order) {
        this.sellerProductId = order.getSellerProductId();
        this.sellerProductName = order.getSellerProductName();
        this.orderId = order.getOrderId();
        this.vendorId = order.getVendorId();
        this.customId = order.getCustomId();
        this.customName = order.getCustomName();
        this.buyProductCount = order.getBuyProductCount();
        this.salePrice = order.getSalePrice();
        this.totalPrice = order.getTotalPrice();
        this.phoneNumber = order.getPhoneNumber();
        this.zipCode = order.getZipCode();
        this.address = order.getAddress();
        this.addressDetail = order.getAddressDetail();
        this.memo = order.getMemo();
        this.deliveryStatus = order.getDeliveryStatus();
        this.insertDateTime = MethodUtil.ChangeDateToString(order.getInsertDateTime());
        this.updateDateTime = MethodUtil.ChangeDateToString(order.getUpdateDateTime());
        return this;
    }

    public static ShopOrderResponseDTO OrderFactory(ShopOrder order) {
        ShopOrderResponseDTO orderResponseDTO = new ShopOrderResponseDTO();
        orderResponseDTO.fromOrder(order);
        return orderResponseDTO;
    }
}
