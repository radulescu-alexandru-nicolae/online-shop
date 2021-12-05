package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name="Product")
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
        name="product_sequance",
        sequenceName = "product_sequance",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator="product_sequance")

    @Column(

            name = "id"
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
    @NotBlank(message="category is necessary")
    @Column(
            name="category",
            columnDefinition = "TEXT"
    )
    private String category;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails=new ArrayList<>();

//    private List<OrderDetails> orderDetailsList=new ArrayList<>();
//
//    public void add(OrderDetails orderDetails){
//        this.orderDetailsList.add(orderDetails);
//    }
//    public void remove(OrderDetails orderDetails){
//        this.orderDetailsList.remove(orderDetails);
//    }
}
