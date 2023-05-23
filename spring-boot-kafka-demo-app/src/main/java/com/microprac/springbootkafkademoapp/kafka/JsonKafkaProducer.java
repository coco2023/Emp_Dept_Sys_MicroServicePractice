package com.microprac.springbootkafkademoapp.kafka;

import com.microprac.springbootkafkademoapp.payload.User;
import com.microprac.springbootkafkademoapp.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    // log
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // send message
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User userMeg) {
        LOGGER.info(String.format("Message send %s", userMeg));
//        kafkaTemplate.send(Constants.TOPIC_NAME, message);
        kafkaTemplate.send(Constants.TOPIC_NAME_JSON, userMeg);
    }

}

