
package com.medvantx.decoupling.repository.impl;

import com.medvantx.decoupling.model.Patient;
import com.medvantx.decoupling.repository.PatientRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryImpl extends BaseRepository<Patient, ObjectId> implements PatientRepository {
    public PatientRepositoryImpl() {
        super(Patient.class);
    }
}

