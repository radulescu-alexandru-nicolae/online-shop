package com.example.apionlineshop.web;

import com.example.apionlineshop.model.Customer;
import com.example.apionlineshop.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/customers")
@CrossOrigin

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    @ResponseStatus(
            value= HttpStatus.OK
    )
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){


     customerService.getRepository().save(customer);
        System.out.println(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @DeleteMapping(path="api/v1/customers")
    public ResponseEntity<Customer> deleteCustomer(@RequestBody String email){
        Customer c=getCustomerByName(email);
        customerService.getRepository().delete(c);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    public Customer getCustomerByName(String email){
   List<Customer> lista=this.getCustomers();
    for(Customer c:lista){
        if(c.getEmail().equals(email)==true){
            return c;
        }
    }
        return null;
    }

}
