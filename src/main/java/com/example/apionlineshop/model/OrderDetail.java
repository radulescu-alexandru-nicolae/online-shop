package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.SEQUENCE;
@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="OrderDetail")
@Table(name="orderDetail")
public class OrderDetail {
    @Id
    @SequenceGenerator(
           name="orderDetail_sequance",
           sequenceName="orderDetail_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "orderDetail_sequance"

    )

    private long id;



    @NotBlank(message = "price is necessary")
    @Column(
            name="price",
            columnDefinition = "DOUBLE"
    )
    private double price;
    @NotBlank(message = "sku is necessary")
    @Column(
            name="sku",
            columnDefinition = "TEXT"
    )
    private String sku;
    @NotBlank(message = "quantity is necessary")
    @Column(
            name="quantity",
            columnDefinition = "INTEGER"
    )
    private int quantity;



    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="product_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="product_fk")
    )
    private Product product;

    @ManyToOne(

            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="order_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="order_fk")
    )
    private Order order;


}
