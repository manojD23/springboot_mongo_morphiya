package com.medvantx.decoupling.service;

import com.medvantx.decoupling.dto.PatientDTO;
import com.medvantx.decoupling.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(String id);

    Patient updatePatient(String id, PatientDTO patientDTO);

    Patient createPatient(PatientDTO patientDTO, String origin);

    void deletePatient(PatientDTO patientDTO);

    List<Patient> getPatientByFirstName(String firstName);
}
