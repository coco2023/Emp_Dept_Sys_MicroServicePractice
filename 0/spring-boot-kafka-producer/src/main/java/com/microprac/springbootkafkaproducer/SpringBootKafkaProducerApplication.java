package com.microprac.springbootkafkaproducer;

import com.microprac.springbootkafkaproducer.kafka.WikiChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
	}

	@Autowired
	WikiChangesProducer producer;

	@Override
	public void run(String... args) throws Exception {
		producer.sendMessage();
	}
}
