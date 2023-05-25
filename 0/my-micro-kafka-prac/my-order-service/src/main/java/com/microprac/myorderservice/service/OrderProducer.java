package com.microprac.myorderservice.service;

import com.microprac.myorderservice.dto.OrderEvent;
import org.apache.catalina.authenticator.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

//    @Autowired
//    private DefaultKafkaConsumerFactory<String, OrderEvent> defaultKafkaConsumerFactory;

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event: %s", orderEvent));

        // create message
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }


}
