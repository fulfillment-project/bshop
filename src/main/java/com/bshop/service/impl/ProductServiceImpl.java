package com.bshop.service.impl;

import com.bshop.data.dto.request.ProductRequestDTO;
import com.bshop.data.dto.request.ShopOrderRequestDTO;
import com.bshop.data.dto.response.ProductResponseDTO;
import com.bshop.data.entity.Product;
import com.bshop.data.entity.ShopOrder;
import com.bshop.data.repository.ProductRepository;
import com.bshop.data.repository.ShopOrderRepository;
import com.bshop.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ShopOrderRepository shopOrderRepository;

    public ProductServiceImpl(ProductRepository productRepository, ShopOrderRepository shopOrderRepository) {
        this.productRepository = productRepository;
        this.shopOrderRepository = shopOrderRepository;
    }

    @Override
    public ProductResponseDTO selectOne(Long sellerProductId) throws Exception {
        Product productDate = this.productRepository.findById(sellerProductId).orElseThrow();
        ProductResponseDTO product = ProductResponseDTO.ProductFactory(productDate, "local");
        return product;
    }

    @Override
    public List<ProductResponseDTO> selectList(ProductRequestDTO productRequestDTO) throws Exception {
//        String fromDate = productRequestDTO.getFromDate();
//        String toDate = productRequestDTO.getToDate();
//        LocalDateTime fromDateTime = null;
//        LocalDateTime toDateTime = null;
//
//        if(fromDate != null && !fromDate.isEmpty()) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            fromDateTime = LocalDateTime.parse(fromDate + " 00:00:00", formatter);
//            toDateTime = LocalDateTime.parse(toDate + " 23:59:59", formatter);
//        }
//
//        System.out.println(fromDate);
//        System.out.println(fromDateTime);

        List<Product> productList = this.productRepository.findByVendorId(productRequestDTO.getVendorId());;

//        if(productRequestDTO.getFromDate() != null && !productRequestDTO.getFromDate().isEmpty()) {
//            if(productRequestDTO.getKeyword() != null && !productRequestDTO.getKeyword().trim().isEmpty()){
//                productList = this.productRepository.findByVendorIdAndSellerProductNameAndInsertDateTimeBetween(productRequestDTO.getVendorId(), productRequestDTO.getKeyword().trim(),fromDateTime, toDateTime);
//            } else {
//                productList = this.productRepository.findByVendorIdAndInsertDateTimeBetween(productRequestDTO.getVendorId(), fromDateTime, toDateTime);
//            }
//        } else {
//
//        }
        return productList.stream().map(product ->
                ProductResponseDTO.ProductFactory(product, "rest")
        ).collect(Collectors.toList());
    }

    @Override
    public void updateQuantity(ProductRequestDTO productRequestDTO) throws Exception {
        Product product = this.productRepository.findById(productRequestDTO.getSellerProductId()).orElseThrow();
        product.setQuantity(productRequestDTO.getQuantity());
        productRepository.save(product);
    }

    //상품 전체 목록 조회(내부)
    @Override
    public List<ProductResponseDTO> selectProductList() throws Exception {
        List<Product> productList = this.productRepository.findAll();
        return productList.stream().map(product ->
                ProductResponseDTO.ProductFactory(product, "local")
        ).collect(Collectors.toList());
    }

    //상품 구매하기(내부)
    @Override
    public void purchaseProduct(Long sellerProductId, ShopOrderRequestDTO orderRequestDTO) throws Exception {
        ShopOrder order = ShopOrder.builder()
                .vendorId(orderRequestDTO.getVendorId())
                .sellerProductId(sellerProductId)
                .sellerProductName(orderRequestDTO.getSellerProductName())
                .customId(2512483)
                .customName(orderRequestDTO.getCustomName())
                .buyProductCount(orderRequestDTO.getBuyProductCount())
                .salePrice(orderRequestDTO.getSalePrice())
                .totalPrice(orderRequestDTO.getTotalPrice())
                .phoneNumber(orderRequestDTO.getPhoneNumber())
                .zipCode(orderRequestDTO.getZipCode())
                .address(orderRequestDTO.getAddress())
                .addressDetail(orderRequestDTO.getAddressDetail())
                .memo(orderRequestDTO.getMemo())
                .orderCheck("F")
                .deliveryStatus("상품 준비 중")
                .build();
        this.shopOrderRepository.save(order);
    }

    @Override
    public void changeConnectType(Long sellerProductId) throws Exception {
        Product product = this.productRepository.findById(sellerProductId).orElseThrow();
        product.setConnectCheck("T");
        this.productRepository.save(product);
    }
}
