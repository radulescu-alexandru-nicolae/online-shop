package com.example.apionlineshop.data;

import com.example.apionlineshop.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
