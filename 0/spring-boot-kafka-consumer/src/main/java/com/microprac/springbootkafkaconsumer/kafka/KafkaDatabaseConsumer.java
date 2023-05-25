package com.microprac.springbootkafkaconsumer.kafka;

import com.microprac.springbootkafkaconsumer.entity.WikimediaData;
import com.microprac.springbootkafkaconsumer.repository.DataRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

//    @Autowired
    DataRepository dataRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "wiki_chanegs",
            groupId = "myGroup"
    )
    public void consume(String eventMsg){
        LOGGER.info(String.format("Event message received: %s", eventMsg));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMsg);

        dataRepository.save(wikimediaData);
    }
}
