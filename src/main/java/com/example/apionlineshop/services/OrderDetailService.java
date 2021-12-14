package com.example.apionlineshop.services;

import com.example.apionlineshop.model.OrderDetail;
import com.example.apionlineshop.repository.OrderDetailRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class OrderDetailService {
private final OrderDetailRepository repository;
public OrderDetailService(OrderDetailRepository repository){
    this.repository=repository;
}
public List<OrderDetail> getOrderDetails(){
    return this.repository.findAll()
;}
}
