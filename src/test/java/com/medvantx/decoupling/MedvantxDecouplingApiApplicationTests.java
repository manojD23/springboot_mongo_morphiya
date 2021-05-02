package com.medvantx.decoupling;

import com.medvantx.decoupling.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.medvantx.decoupling")
@SpringBootTest
class MedvantxDecouplingApiApplicationTests {

	@Autowired
	PatientService patientService;

	@Test
	void contextLoads() {
	    System.out.println("Hello Manoj");
	}

}

