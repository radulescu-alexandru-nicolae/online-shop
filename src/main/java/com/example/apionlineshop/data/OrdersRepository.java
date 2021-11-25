package com.example.apionlineshop.data;

import com.example.apionlineshop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
