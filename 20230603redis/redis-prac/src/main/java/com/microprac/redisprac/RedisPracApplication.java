package com.microprac.redisprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// refer: https://github.com/dinhkhiemtran/redis_cache_session_demo_spring_boot/blob/develop/src/main/java/com/khiemtran/redis_demo_spring_boot/service/imp/UserRedisServiceImp.java
// remember to open the Ubuntu Redis!!

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RedisPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisPracApplication.class, args);
	}


}
