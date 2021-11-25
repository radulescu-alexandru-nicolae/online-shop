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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Orders")
@Table(name="orders")
public class Orders {
    @Id
    @SequenceGenerator(
            name="orders_sequance",
            sequenceName = "orders_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "orders_sequance"
    )
    @Column(
            name="id",
            updatable = false,
            columnDefinition = "INTEGER"
    )

    private long id;
    @Column(
            name="customer_id",
            columnDefinition = "INTEGER"
    )
    private long customerId;
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
    private String order_address;
    @NotBlank(message = "order_email is necessary")
    @Column(
            name="order_email",
            columnDefinition = "TEXT"
    )
    private String order_email;
    @NotBlank(message = "order_date is necessary")
    @Column(
            name="order_date",
            columnDefinition = "DATE"
    )
    private LocalDate order_date;
    @NotBlank(message = "order_status is necessary")
    @Column(
            name="order_status",
            columnDefinition = "BOOLEAN"
    )
    private boolean order_status;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "order",
            fetch = FetchType.EAGER
    )
    private List<OrderDetails>ordersDetails= new ArrayList<>();


    public void  add(OrderDetails orderDetails){

         this.ordersDetails.add(orderDetails);
    }

    private void  removeOrderDetails(OrderDetails orderDetails){


        this.ordersDetails.remove(orderDetails);
    }

    @ManyToOne
    @JsonManagedReference
    @JoinColumn
            (
                    name="curstomer_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey( name="customers_id_fk")
            )
    private Customers customer;


}
