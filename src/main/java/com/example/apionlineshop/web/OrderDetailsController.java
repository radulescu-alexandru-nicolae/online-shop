package com.example.apionlineshop.web;

import com.example.apionlineshop.model.OrderDetail;
import com.example.apionlineshop.services.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/orderdetails")
@CrossOrigin
public class OrderDetailsController {
    private final OrderDetailService orderDetailService;


    public OrderDetailsController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @GetMapping
    @ResponseStatus(
            value= HttpStatus.OK
    )
    public List<OrderDetail> getOrderDetails(){
        return orderDetailService.getOrderDetails();
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetailService.getRepository().save(orderDetail);

        return new ResponseEntity<>(orderDetail,HttpStatus.OK);
    }


    @DeleteMapping(path="api/v1/orderdetails")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@RequestBody int id){

        OrderDetail o=getOrderDetailId(id);
        orderDetailService.getRepository().delete(o);

        return new ResponseEntity<>(o,HttpStatus.OK);

    }


    public OrderDetail getOrderDetailId(int id){
        List<OrderDetail> lista=orderDetailService.getRepository().findAll();
        for(OrderDetail o:lista){
            if(o.getId()==id){
                return o;
            }
        }
        return null;

    }



}
