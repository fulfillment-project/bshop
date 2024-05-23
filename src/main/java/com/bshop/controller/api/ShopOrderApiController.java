package com.bshop.controller.api;

import com.bshop.data.dto.request.ShopOrderRequestDTO;
import com.bshop.data.dto.response.ShopOrderResponseDTO;
import com.bshop.service.impl.ShopOrderServiceImpl;
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

    @PostMapping("/ordersheets")
    public ResponseEntity<Map<String, Object>> sellerSelectOrderList(@RequestBody ShopOrderRequestDTO orderRequestDTO) throws Exception {
        List<ShopOrderResponseDTO> orderList = this.orderService.sellerSelectOrderList(orderRequestDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "주문 목록 조회를 완료했습니다.");
        map.put("data", orderList);

        return ResponseEntity.ok().body(map);
    }

    @PutMapping("/{orderId}/orders/invoices")
    public ResponseEntity<Map<String, Object>> trakingNumberUpdate(@PathVariable Integer orderId, @RequestBody ShopOrderRequestDTO orderRequestDTO) throws Exception{
        orderRequestDTO.setOrderId(orderId);
        this.orderService.trakingNumberUpdate(orderRequestDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "SUCCESS");
        map.put("message", "송장 업로드를 완료했습니다.");

        return ResponseEntity.ok().body(map);
    }
}
