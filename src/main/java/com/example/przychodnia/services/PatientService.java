package com.example.przychodnia.services;

import com.example.przychodnia.models.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient addPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}
