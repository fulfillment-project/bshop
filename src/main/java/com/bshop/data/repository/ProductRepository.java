package com.bshop.data.repository;

import com.bshop.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product where connect_check ='F'",nativeQuery = true)
    public List<Product> findByVendorId(Integer VendorId);

//    public List<Product> findByVendorIdAndInsertDateTimeBetween(Integer vendorId, LocalDateTime fromDate, LocalDateTime toDate);
//    public List<Product> findByVendorIdAndSellerProductNameAndInsertDateTimeBetween(Integer vendorId, String sellerProductName,LocalDateTime fromDate, LocalDateTime toDate);
}
