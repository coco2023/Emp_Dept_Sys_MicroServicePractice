package com.microprac.springbootkafkademoapp.kafka;

import com.microprac.springbootkafkademoapp.payload.User;
import com.microprac.springbootkafkademoapp.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = Constants.TOPIC_NAME_JSON, groupId = "myGroup")
    public void consumer(User user) {
        LOGGER.info(String.format("Json Mesg received: %s", user.toString()));
    }
}
