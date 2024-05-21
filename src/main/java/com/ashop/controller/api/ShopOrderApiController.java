package com.ashop.controller.api;

import com.ashop.data.dto.request.ShopOrderRequestDTO;
import com.ashop.data.dto.response.ShopOrderResponseDTO;
import com.ashop.service.impl.ShopOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/providers/openapi/apis/api/v4/vendors")
public class ShopOrderApiController {
    private final ShopOrderServiceImpl orderService;

    public ShopOrderApiController(ShopOrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{vendorId}/ordersheets")
    public ResponseEntity<Map<String, Object>> sellerSelectOrderList(@PathVariable Integer vendorId, @RequestBody ShopOrderRequestDTO orderRequestDTO) throws Exception {
        orderRequestDTO.setVendorId(vendorId);
        List<ShopOrderResponseDTO> orderList = this.orderService.sellerSelectOrderList(orderRequestDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "주문 목록 조회를 완료했습니다.");
        map.put("data", orderList);

        return ResponseEntity.ok().body(map);
    }

    @PutMapping("/{orderId}/orders/invoices")
    public ResponseEntity<Map<String, Object>> trakingNumberUpdate(@PathVariable Long orderId, @RequestBody ShopOrderRequestDTO orderRequestDTO) throws Exception{
        orderRequestDTO.setOrderId(orderId);
        this.orderService.trakingNumberUpdate(orderRequestDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "송장 업로드를 완료했습니다.");

        return ResponseEntity.ok().body(map);
    }
}
