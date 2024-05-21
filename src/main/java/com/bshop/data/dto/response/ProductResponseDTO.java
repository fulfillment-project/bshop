package com.bshop.data.dto.response;


import com.bshop.data.entity.Product;
import com.bshop.util.MethodUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDTO {
    private Long sellerProductId;
    private String sellerProductName;
    private String content;
    private Integer vendorId;
    private Integer salePrice;
    private Integer maxBuyCount;
    private Integer quantity;
    private String brand;
    private String image;
    private Integer deliveryCharge;
    private String insertDateTime;
    private String updateDateTime;

    public ProductResponseDTO fromProduct(Product product) {
        this.sellerProductId = product.getSellerProductId();
        this.sellerProductName = product.getSellerProductName();
        this.content = product.getContent();
        this.vendorId = product.getVendorId();
        this.salePrice = product.getSalePrice();
        this.quantity = product.getQuantity();
        this.brand = product.getBrand();
        this.image = MethodUtil.changeImageUrl("http://localhost:9080/", "static/img/",product.getImage());
        this.deliveryCharge = product.getDeliveryCharge();
        this.insertDateTime = MethodUtil.ChangeDateToString(product.getInsertDateTime());
        this.updateDateTime = MethodUtil.ChangeDateToString(product.getUpdateDateTime());
        return this;
    }

    public static ProductResponseDTO ProductFactory(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.fromProduct(product);
        return productResponseDTO;
    }
}
