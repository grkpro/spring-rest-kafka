package com.rk.messaging.rest;

import com.rk.messaging.dao.Customer;
import com.rk.messaging.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/customer/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.create(customer);
        customerService.createJson(customer);
    }
}
