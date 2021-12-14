package com.example.apionlineshop.DTO;

import lombok.Data;

@Data
public class OrderDto {


    private String name;
    private int customerId;
    private double price;
    private int quantity;
    private String link;

    public OrderDto(String name, int customerId, double price, int quantity, String link) {
        this.name = name;
        this.customerId = customerId;
        this.price = price;
        this.quantity = quantity;
        this.link = link;
    }



}
