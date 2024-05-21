package com.bshop.data.repository;

import com.bshop.data.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
    List<ShopOrder> findByVendorIdAndUpdateDateTimeBetween(Integer vendorId, LocalDateTime fromDate, LocalDateTime toDate);
    List<ShopOrder> findByCustomId(Integer customId);
}
