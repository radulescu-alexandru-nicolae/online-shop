package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Order")
@Table(name="orders")
public class Order {
    @Id
    @SequenceGenerator(
            name="order_sequance",
            sequenceName = "order_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "orders_sequance"
    )
    private long id;



    @NotBlank(message = "ammount is necessary")
    @Column(
            name="ammount",
            columnDefinition = "INTEGER"
    )
    private int ammount;



    @NotBlank(message = "order_email is necessary")
    @Column(
            name="order_address",
            columnDefinition = "TEXT"
    )
    private String ordeAddres;
    @NotBlank(message = "order_email is necessary")
    @Column(
            name="order_email",
            columnDefinition = "TEXT"
    )
    private String orderEmail;
    @NotBlank(message = "order_date is necessary")
    @Column(
            name="order_date"
            ,columnDefinition = "DATE"
    )
    private LocalDate orderDate;
    @NotBlank(message = "order_status is necessary")
    @Column(
            name="order_status",
            columnDefinition = "BOOLEAN"
    )
    private boolean orderStatus;


    @ManyToOne(
            cascade = CascadeType.ALL
    )

    @JoinColumn(
            name="customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="customer_fk"
            ))
    @JsonBackReference
    private Customer customer;

  @OneToMany(mappedBy="order")
    private List<OrderDetail> orderDetails=new ArrayList<>();




}
