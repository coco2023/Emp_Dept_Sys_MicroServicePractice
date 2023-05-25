package com.microprac.springbootkafkaproducer.kafka;

import com.launchdarkly.eventsource.EventSource;
import com.microprac.springbootkafkaproducer.handler.WikiChangesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
@Service
public class WikiChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiChangesProducer.class);

    public KafkaTemplate<String, String> kafkaTemplate;

    public  WikiChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException{
        String topic = "wiki_chanegs";

        // read realtime spring data from wiki; use event source
        EventHandler eventHandler = new WikiChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }

}
