package com.rk.messaging.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Component
public class CustomerConsumer {
    Logger logger = LoggerFactory.getLogger(CustomerConsumer.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private String message;

    @KafkaListener(topics = "${kafka.customer.topic}")
    public void listenKafkaTopic(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String receivedTopic) {
        logger.info(" Consuming Message from Topic [ " + receivedTopic + " ], Message is = " + message);
        createFile(message, receivedTopic);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private void createFile(String message, String topicName) {
        StringBuffer fileName = new StringBuffer();
        fileName.append(topicName).append("_")
                .append(simpleDateFormat.format(new Timestamp(System.currentTimeMillis()))).append("_")
                .append(UUID.randomUUID().toString())
                .append(".txt");
        FileWriter fileWriter;
        File file;
        try {
            file = new File(new StringBuilder().append(System.getProperty("user.dir"))
                    .append(File.separator).append("data")
                    .append(File.separator).append(fileName.toString()).toString());
            fileWriter = new FileWriter(file);
            fileWriter.write(message);
            fileWriter.close();
        } catch (Exception e) {
            logger.error("Error while creating file : " + e.getMessage());
        }
    }
}
