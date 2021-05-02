package com.medvantx.decoupling.controller;

import com.medvantx.decoupling.dto.PatientDTO;
import com.medvantx.decoupling.model.Patient;
import com.medvantx.decoupling.service.PatientService;
import com.medvantx.decoupling.utils.RestApiV1;
import dev.morphia.Key;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestApiV1
public class PatientController {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PatientService patientService;


    @GetMapping(value = "patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patientDTOs = patientService.getAllPatients().stream().map(map -> modelMapper.map(map, PatientDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(patientDTOs);
    }

    @GetMapping(value = "patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") String id) {
        PatientDTO patientDTOs = modelMapper.map(patientService.getPatientById(id),PatientDTO.class);
        return ResponseEntity.ok(patientDTOs);
    }

    @PostMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patient) {
        Patient pat = patientService.createPatient(patient,"");
        return ResponseEntity.ok(modelMapper.map(pat, PatientDTO.class));
    }

    @PutMapping(value = "/patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") String id,@RequestBody PatientDTO patient) {
        Patient pat = patientService.updatePatient(id,patient);
        return ResponseEntity.ok(modelMapper.map(pat, PatientDTO.class));
    }

    @GetMapping(value = "patient/name/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDTO>> getPatientByName(@PathVariable("firstname") String firstName) {
        List<PatientDTO> patientDTOs = patientService.getPatientByFirstName(firstName).stream().map(map -> modelMapper.map(map, PatientDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(patientDTOs);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
