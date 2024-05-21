package com.bshop.service;

import com.bshop.data.dto.request.ProductRequestDTO;
import com.bshop.data.dto.request.ShopOrderRequestDTO;
import com.bshop.data.dto.response.ProductResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    public ProductResponseDTO selectOne(Long sellerProductId) throws Exception;

    public List<ProductResponseDTO> selectList(ProductRequestDTO productRequestDTO) throws Exception;

    public void updateQuantity(ProductRequestDTO productRequestDTO) throws Exception;

    //상품 전체 목록 조회(내부)
    public List<ProductResponseDTO> selectProductList() throws Exception;

    //상품 구매하기
    public void purchaseProduct(@PathVariable Long sellerProductId, ShopOrderRequestDTO orderRequestDTO) throws Exception;

}
