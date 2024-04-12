package com.example.przychodnia.services;

import com.example.przychodnia.models.Doctor;
import com.example.przychodnia.models.Patient;

import com.example.przychodnia.models.Prescription;
import com.example.przychodnia.models.SickLeave;
import com.example.przychodnia.repository.PatientRepository;
import com.example.przychodnia.repository.PrescriptionRepository;
import com.example.przychodnia.services.interfaces.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;




    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void sendPatient(Patient patient) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String reqJson = mapper.writeValueAsString(patient);
            kafkaTemplate.send("patient", reqJson);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void sendSickLeave(SickLeave sickLeave) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String reqJson = mapper.writeValueAsString(sickLeave);
            System.out.println(sickLeave);
            kafkaTemplate.send("sickLeave", reqJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        patient.addPrescription(prescription);
        SickLeave sickLeave = new SickLeave();
        sickLeave.setDaysOfSickLeave(prescription.getDaysOfSickLeave());
        sickLeave.setPesel((patient.getPesel()));
        sendSickLeave(sickLeave);
        return patientRepository.save(patient);
    }
}
