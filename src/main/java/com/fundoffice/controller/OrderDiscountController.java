package com.fundoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fundoffice.model.OrderDiscount;
import com.fundoffice.model.OrderRequest;
import com.fundoffice.service.OrderDiscountService;

@RestController
public class OrderDiscountController {
 
    @Autowired
    private OrderDiscountService orderDiscountService;

    @GetMapping("/hello")
    public void  hello() {
    	System.out.println("Hello........... TEST");
    }
    

    
    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
    	System.out.println("Hello........... get-discount");
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
