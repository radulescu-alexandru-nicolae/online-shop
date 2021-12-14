package com.example.apionlineshop.services;

import com.example.apionlineshop.model.Customer;
import com.example.apionlineshop.repository.CustomerRepository;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers(){
        return this.repository.findAll();

    }

    public CustomerRepository getRepository() {
        return repository;
    }
}
