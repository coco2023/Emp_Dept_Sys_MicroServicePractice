package com.microprac.mystockservice.service;

import com.microprac.mystockservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "order_topic",
            groupId = "stock"
    )
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order Event Received: %s", orderEvent.toString()));

        //save the orderevent into the database
    }


}
