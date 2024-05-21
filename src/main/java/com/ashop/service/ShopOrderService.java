package com.ashop.service;

import com.ashop.data.dto.request.ShopOrderRequestDTO;
import com.ashop.data.dto.response.ShopOrderResponseDTO;

import java.util.List;

public interface ShopOrderService {
    List<ShopOrderResponseDTO> sellerSelectOrderList(ShopOrderRequestDTO orderRequestDTO) throws Exception;
    void trakingNumberUpdate(ShopOrderRequestDTO order) throws Exception;

    //주문 조회(내부)
    List<ShopOrderResponseDTO> selectOrderList() throws Exception;
}
