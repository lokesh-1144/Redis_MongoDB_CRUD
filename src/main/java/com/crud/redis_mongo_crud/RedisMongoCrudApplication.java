package com.crud.redis_mongo_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisMongoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisMongoCrudApplication.class, args);
	}

}
