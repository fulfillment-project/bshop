package com.bshop.service;

import com.bshop.data.dto.request.ShopOrderRequestDTO;
import com.bshop.data.dto.response.ShopOrderResponseDTO;

import java.util.List;

public interface ShopOrderService {
    List<ShopOrderResponseDTO> sellerSelectOrderList(ShopOrderRequestDTO orderRequestDTO) throws Exception;
    void trakingNumberUpdate(ShopOrderRequestDTO order) throws Exception;

    //주문 조회(내부)
    List<ShopOrderResponseDTO> selectOrderList() throws Exception;
}
