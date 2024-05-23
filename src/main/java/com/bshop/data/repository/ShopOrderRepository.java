package com.bshop.data.repository;

import com.bshop.data.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
    @Query(value = "select s.* from shop_order s, product p where s.vendor_id = :vendorId and p.connect_check = 'T' and s.order_check ='F' and s.seller_product_id = p.seller_product_id",nativeQuery = true )
    List<ShopOrder> findByVendorIdAndUpdateDateTimeBetween(@Param("vendorId")Integer vendorId);
    List<ShopOrder> findByCustomId(Integer customId);

    ShopOrder findByOrderId(Integer orderId);
}
