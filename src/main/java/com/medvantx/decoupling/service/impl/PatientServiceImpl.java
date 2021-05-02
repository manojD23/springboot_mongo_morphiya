package com.medvantx.decoupling.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medvantx.decoupling.dto.PatientDTO;
import com.medvantx.decoupling.model.Patient;
import com.medvantx.decoupling.repository.PatientRepository;
import com.medvantx.decoupling.service.PatientService;
import dev.morphia.Datastore;
import dev.morphia.Key;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    Datastore datastore;


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.createQuery()
                .find().toList();
    }

    @Override
    public Patient getPatientById(String id) {
        return (Patient) new Patient().findById(id);
        /*return patientRepository.findById(id);*/
    }

    @Override
    public Patient updatePatient(String id, PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);


        Query<Patient> query = patientRepository.createQuery()
                .field("id").equal(id);
        UpdateOperations<Patient> updateOperations = setValuesForUpdate(
                patientRepository.createUpdateOperations(),
                patient);

        UpdateResults results = patientRepository.update(query, updateOperations);
        return query.first();

    }

    private UpdateOperations setValuesForUpdate(UpdateOperations<Patient> updateOperations,
                                                Patient patient) {

        updateOperations.set("zip_code", patient.getZipCode());
        updateOperations.set("patient_pointer", patient.getPatientPointer());
        updateOperations.set("email_address", patient.getEmailAddress());
        updateOperations.set("primary_phone", patient.getPrimaryPhone());
        updateOperations.set("alternate_phone", patient.getAlternatePhone());
        updateOperations.set("gender", patient.getGender());
        return updateOperations;
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO, String origin) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        Key<Patient> savedPatient = patientRepository.create(patient);
        return patient;
    }

    @Override
    public void deletePatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patientRepository.delete(patient);
    }

    @Override
    public List<Patient> getPatientByFirstName(String firstName) {

        List<Patient> abc = patientRepository.createQuery().field("first_name").equal(firstName).find().toList();


        // testing

      /*  // ds is a Datastore instance
        Query<Order> q = ds.createQuery(Order.class).filter("createdDate >=", date);
        List<Order> ordersAndReturns = q.asList();*/

       // Query q = ds.createQuery(Order.class).filter("createdDate >=", new java.util.Date());
        //disableValidation()


        List<Patient> books = patientRepository.createQuery()
                .field("first_name")
                .notEqual(null)
                .find().toList();

        List<Patient> booksa = patientRepository.findAll();
        System.out.println(booksa.toString());
        return abc;

    }
}
