package com.example.apionlineshop.testttt;


import com.example.apionlineshop.services.CustomerService;
import com.example.apionlineshop.services.OrderService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class Testeeee {
private OrderService orderService;
private CustomerService customerService;

    public Testeeee(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }




    @Bean
    public CommandLineRunner   tess() {



//        return  args -> {
//
//            orderService.getOrders().stream().forEach(System.out::println);
//        };
        return args->{
            customerService.getCustomers().stream().forEach(System.out::println);

        };


    }


}
