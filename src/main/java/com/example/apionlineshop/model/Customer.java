package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Customer")
@Table(name="customers")
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer_sequance",
            sequenceName = "customer_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator="customer_sequance"

    )
    private long id;


    @NotBlank(message = "email is necessary")
    @Column(
            name="email",
            columnDefinition = "TEXT"
    )
    private String email;
    @NotBlank(message = "password is necessary")
    @Column(
            name="password",
            columnDefinition = "TEXT"
    )
    private String password;
    @NotBlank(message = "addres is necessary")
    @Column(
            name="addres",
            columnDefinition = "TEXT"
    )
    private String addres;

    @OneToMany(mappedBy =  "customer")
    private List<Order> orders= new ArrayList<>();



public Customer(String email,String password,String addres){
    this.email=email;
    this.password=password;
    this.addres=addres;
}

}
