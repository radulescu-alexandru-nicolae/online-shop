package com.example.apionlineshop.services;

import com.example.apionlineshop.model.Product;
import com.example.apionlineshop.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServoice {

    private final ProductsRepository repository;

    public ProductServoice(ProductsRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts(){

        return  this.repository.findAll();
    }


}
