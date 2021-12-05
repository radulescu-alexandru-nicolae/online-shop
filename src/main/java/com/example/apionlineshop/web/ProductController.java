package com.example.apionlineshop.web;

import com.example.apionlineshop.model.Product;
import com.example.apionlineshop.services.ProductServoice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/products")
@CrossOrigin
public class ProductController {


    private  final ProductServoice productServoice;


    public ProductController(ProductServoice productServoice) {
        this.productServoice = productServoice;
    }


    @GetMapping
    @ResponseStatus(
            value = HttpStatus.OK
    )
    public List<Product> getProduscts(){

        return productServoice.getAllProducts();
    }
}
