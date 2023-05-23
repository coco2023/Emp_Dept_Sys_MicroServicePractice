package com.microprac.springbootkafkademoapp.kafka;

import com.microprac.springbootkafkademoapp.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    // log
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // send message
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message send %s", message));
        kafkaTemplate.send(Constants.TOPIC_NAME, message);
    }

}
