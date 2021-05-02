package com.medvantx.decoupling.service;

import com.medvantx.decoupling.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @Test
    @DisplayName("Patient Service Test ")
    void testSubscriptionMessage() {

        String firstName = "manoj";

        List<Patient> patient = patientService.getPatientByFirstName(firstName);

        assertEquals("manoj", patient.get(0).getFirstName());
    }
}
