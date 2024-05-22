package com.bshop.service.impl;

import com.bshop.data.dto.request.ShopOrderRequestDTO;
import com.bshop.data.dto.response.ShopOrderResponseDTO;
import com.bshop.data.entity.ShopOrder;
import com.bshop.data.repository.ShopOrderRepository;
import com.bshop.service.ShopOrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShopOrderServiceImpl implements ShopOrderService {
    private final ShopOrderRepository shopOrderRepository;

    public ShopOrderServiceImpl(ShopOrderRepository shopOrderRepository) {
        this.shopOrderRepository = shopOrderRepository;
    }

    @Override
    public List<ShopOrderResponseDTO> sellerSelectOrderList(ShopOrderRequestDTO orderRequestDTO) throws Exception {
//        String fromDate = orderRequestDTO.getFromDate();
//        String toDate = orderRequestDTO.getToDate();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime fromDateTime = LocalDateTime.parse(fromDate + " 00:00:00", formatter);
//        LocalDateTime toDateTime = LocalDateTime.parse(toDate + " 23:59:59", formatter);

        List<ShopOrder> orderList = this.shopOrderRepository.findByVendorIdAndUpdateDateTimeBetween(orderRequestDTO.getVendorId());
        System.out.println(orderList.size());
        return orderList.stream().map(order ->
                ShopOrderResponseDTO.OrderFactory(order)
        ).collect(Collectors.toList());
    }

    @Override
    public void trakingNumberUpdate(ShopOrderRequestDTO order) throws Exception {
        ShopOrder orderDate = this.shopOrderRepository.findById(order.getOrderId()).orElseThrow();
        orderDate.setTrakingNumber(order.getTrakingNumber());
        this.shopOrderRepository.save(orderDate);
    }

    @Override
    public List<ShopOrderResponseDTO> selectOrderList() throws Exception {
        Integer customId = 2512483;
        List<ShopOrder> orderList = this.shopOrderRepository.findByCustomId(customId);
        return orderList.stream().map(order ->
                ShopOrderResponseDTO.OrderFactory(order)
        ).collect(Collectors.toList());
    }
}
