package com.example.apionlineshop.services;

import com.example.apionlineshop.model.Order;
import com.example.apionlineshop.repository.OrdersRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@Data
public class OrderService {
    private final OrdersRepository repository;

    public OrderService(OrdersRepository repository) {
        this.repository = repository;
    }

    public List<Order> getOrders(){

        return this.repository.findAll();
    }





}
