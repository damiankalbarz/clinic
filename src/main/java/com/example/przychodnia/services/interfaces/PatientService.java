package com.example.przychodnia.services.interfaces;

import com.example.przychodnia.models.Patient;
import com.example.przychodnia.models.Prescription;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient addPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    Patient addPrescriptionToPatient(Long patientId, Prescription prescription);

    void deletePatient(Long id);
     void sendPatient(Patient patient);

}
