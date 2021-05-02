package com.medvantx.decoupling.repository;

import com.medvantx.decoupling.model.Patient;
import org.bson.types.ObjectId;

public interface PatientRepository extends CrudRepository<Patient, ObjectId>{
}
