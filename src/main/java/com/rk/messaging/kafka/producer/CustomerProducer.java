package com.rk.messaging.kafka.producer;

import com.rk.messaging.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerProducer {
    Logger logger = LoggerFactory.getLogger(CustomerProducer.class);
    @Value(value = "${kafka.customer.topic}")
    private String topic;

    @Autowired
    public KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    public KafkaTemplate<String, Customer> jsonKafkaTemplate;

    public void sendMessage(String message) {
        logger.info("Publishing Message to Topic [ " + topic + " ]" + message);
        stringKafkaTemplate.send(topic, message);
        logger.info("Message published successfully to Topic [ " + topic + " ]");
    }

    public void sendJsonMessage(Customer customer) {
        logger.info("Publishing Message to Topic [ " + topic + " ]" + customer);
        jsonKafkaTemplate.send(topic, customer);
        logger.info("Message published successfully to Topic [ " + topic + " ]");
    }
}
