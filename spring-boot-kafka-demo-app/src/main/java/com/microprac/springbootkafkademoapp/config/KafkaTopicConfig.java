package com.microprac.springbootkafkademoapp.config;

import com.microprac.springbootkafkademoapp.util.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic test() {
//        return TopicBuilder.name("test-topic")
        return TopicBuilder.name(Constants.TOPIC_NAME)
                .build();
    }

    @Bean
    public NewTopic testTopicJson() {
        return TopicBuilder.name(Constants.TOPIC_NAME_JSON)
                .build();
    }

}
