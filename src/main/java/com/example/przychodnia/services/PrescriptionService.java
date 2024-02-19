package com.example.przychodnia.services;

import com.example.przychodnia.models.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> getAllPrescriptions();

    Prescription getPrescriptionById(Long id);

    Prescription addPrescription(Prescription prescription);

    Prescription updatePrescription(Long id, Prescription prescription);

    void deletePrescription(Long id);
}
