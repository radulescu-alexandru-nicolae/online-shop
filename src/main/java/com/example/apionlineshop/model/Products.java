package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name="Products")
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @SequenceGenerator(
        name="products_sequance",
        sequenceName = "products_sequance",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator="products_sequance"
    )
    @Column(
            name="id",
            updatable = false,
            columnDefinition = "INTEGER"
    )
    private long id;
    @NotBlank(message = "name is necessary")
    @Column(
            name="name",
            columnDefinition = "TEXT"
    )
    private String name;
    @NotBlank(message = "price is necessary")
    @Column(
            name="price",
            columnDefinition = "DOUBLE"
    )
    private double price;
    @NotBlank(message = "image is necessary")
    @Column(
            name="image",
            columnDefinition = "BLOB"
    )
    private byte[] image;
    @NotBlank(message = "create_date is necessary")
    @Column(
            name="create_date",
            columnDefinition = "DATE"
    )
    private LocalDate date;
    @NotBlank(message = "stock is necessary")
    @Column(
            name="stock",
            columnDefinition = "INTEGER"
    )
    private int stock;

    @JsonManagedReference
    @OneToMany
            (
                    cascade = CascadeType.ALL,
                    mappedBy = "products",
                    fetch = FetchType.EAGER

            )
    private List<OrderDetails> orderDetailsList=new ArrayList<>();

    public void add(OrderDetails orderDetails){
        this.orderDetailsList.add(orderDetails);
    }
    public void remove(OrderDetails orderDetails){
        this.orderDetailsList.remove(orderDetails);
    }
}
