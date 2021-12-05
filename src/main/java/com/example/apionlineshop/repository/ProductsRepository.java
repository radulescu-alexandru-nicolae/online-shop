package com.example.apionlineshop.repository;

import com.example.apionlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product,Long> {
}
