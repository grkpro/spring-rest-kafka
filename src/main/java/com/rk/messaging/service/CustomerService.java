package com.rk.messaging.service;

import com.rk.messaging.dao.Customer;
import com.rk.messaging.kafka.producer.CustomerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    public CustomerProducer customerProducer;

    public void create(Customer customer) {
        customerProducer.sendMessage(customer.toString());
    }

    public void createJson(Customer customer) {
        customerProducer.sendJsonMessage(customer);
    }
}
