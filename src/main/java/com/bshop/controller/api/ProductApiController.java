package com.bshop.controller.api;

import com.bshop.data.dto.request.ProductRequestDTO;
import com.bshop.data.dto.response.ProductResponseDTO;
import com.bshop.service.impl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/providers/seller_api/apis/api/v1/marketplace")
public class ProductApiController {
    private final ProductServiceImpl productService;

    public ProductApiController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    //상품 개별 조회
    @GetMapping("/seller-products/{sellerProductId}")
    public ResponseEntity<Map<String, Object>> selectProduct(@PathVariable Long sellerProductId) throws Exception {
        ProductResponseDTO product = productService.selectOne(sellerProductId);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "상품 조회가 완료했습니다.");
        map.put("data", product);

        return ResponseEntity.ok().body(map);
    }


    //상품 전체 조회
    @PostMapping("/select/seller-products")
    public ResponseEntity<Map<String, Object>> selectProductList(@RequestBody(required = false) ProductRequestDTO product) throws Exception {
        List<ProductResponseDTO> productList = this.productService.selectList(product);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "상품 목록 조회가 완료했습니다.");
        map.put("data", productList);

        return ResponseEntity.ok().body(map);
    }

    //상품 재고 수량 변경
    @PutMapping("/update/seller-products/{sellerProductId}")
    public ResponseEntity<Map<String, Object>> updateQuantity(@PathVariable Long sellerProductId, @RequestBody ProductRequestDTO product) throws Exception {
        product.setSellerProductId(sellerProductId);
        this.productService.updateQuantity(product);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "재고 변경을 완료했습니다.");

        return ResponseEntity.ok().body(map);
    }
}
