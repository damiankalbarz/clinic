package com.example.przychodnia.services;

import com.example.przychodnia.models.Patient;

import com.example.przychodnia.models.Prescription;
import com.example.przychodnia.repository.PatientRepository;
import com.example.przychodnia.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {



    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }





    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient addPrescriptionToPatient(Long patientId, Prescription prescription) {
        Patient patient = getPatientById(patientId);
        List<Prescription> prescriptionList = patient.getPrescriptionList();
        prescriptionList.add(prescription);
        patient.setPrescriptionList(prescriptionList);
        return patientRepository.save(patient);
    }
}
