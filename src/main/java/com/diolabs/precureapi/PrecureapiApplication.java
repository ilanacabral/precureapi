package com.diolabs.precureapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class PrecureapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrecureapiApplication.class, args);
	}

}
