package com.example.apionlineshop.data;

import com.example.apionlineshop.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetails,Long> {
}
