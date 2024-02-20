package com.example.przychodnia.services;

import com.example.przychodnia.models.Prescription;
import com.example.przychodnia.services.interfaces.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.przychodnia.repository.PrescriptionRepository;


import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElse(null);
    }

    @Override
    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription updatedPrescription) {
        Optional<Prescription> existingPrescription = prescriptionRepository.findById(id);

        if (existingPrescription.isPresent()) {
            Prescription prescription = existingPrescription.get();
            prescription.setDescription(updatedPrescription.getDescription());
            prescription.setPatient(updatedPrescription.getPatient());
            return prescriptionRepository.save(prescription);
        }

        return null;
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
