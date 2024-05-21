package com.ashop.data.repository;

import com.ashop.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByVendorId(Integer VendorId);
    public List<Product> findByVendorIdAndInsertDateTimeBetween(Integer vendorId, LocalDateTime fromDate, LocalDateTime toDate);
    public List<Product> findByVendorIdAndSellerProductNameAndInsertDateTimeBetween(Integer vendorId, String sellerProductName,LocalDateTime fromDate, LocalDateTime toDate);
}
