package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.SEQUENCE;
@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="OrderDetails")
@Table(name="orderDetails")
public class OrderDetails {
    @Id
    @SequenceGenerator(
           name="orderDetails_sequance",
           sequenceName="orderDetails_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "orderDetails_sequance"

    )
    @Column(
            name="id",
            columnDefinition = "INTEGER",
            updatable = false

    )
    private long id;
    @NotBlank(message = "order_id is necessary")
    @Column(
            name="order_id",
            columnDefinition = "INTEGER"

    )
    private long orderId;
    @NotBlank(message = "product_id is necessary")
    @Column(
            name="product_id",
            columnDefinition = "INTEGER"
    )
    private long productId;
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(

            name="order_details_id",
            referencedColumnName = "ordersDetails",
            foreignKey = @ForeignKey(
                    name="order_details_id_fk"
            )

    )
    private  Orders order;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(

            referencedColumnName = "ordersDetailsList",
            foreignKey = @ForeignKey(
                    name="products_id_fk"
            )
    )
    private Products products;



}
