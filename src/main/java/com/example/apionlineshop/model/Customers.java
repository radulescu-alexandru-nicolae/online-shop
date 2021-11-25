package com.example.apionlineshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Entity(name="Customers")
@Table(name="customers")
public class Customers {
    @Id
    @SequenceGenerator(
            name="customers_sequance",
            sequenceName = "customers_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator="customers_sequance"

    )
    @Column(
            name="id",
            updatable = false,
            columnDefinition = "INTEGER"
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

@JsonManagedReference
@OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "customer",
        fetch = FetchType.EAGER
)
    private List<Orders> ordersList=new ArrayList<>();
}
