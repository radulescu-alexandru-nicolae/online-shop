package com.example.apionlineshop.repository;

import com.example.apionlineshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order,Long> {
}
