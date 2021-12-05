package com.example.apionlineshop.repository;

import com.example.apionlineshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetail,Long> {
}
