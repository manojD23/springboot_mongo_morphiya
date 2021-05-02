package com.medvantx.decoupling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication()
@ComponentScan(basePackages = "com.medvantx.decoupling")
public class MedvantxDecouplingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedvantxDecouplingApiApplication.class, args);
	}

}
