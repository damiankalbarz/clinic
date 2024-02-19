package com.example.przychodnia.controllers;

import com.example.przychodnia.models.Clinic;
import com.example.przychodnia.models.Doctor;
import com.example.przychodnia.models.Patient;
import com.example.przychodnia.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) {
        return clinicService.saveClinic(clinic);
    }

    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @GetMapping("/{id}")
    public Clinic getClinicById(@PathVariable Long id) {
        return clinicService.getClinicById(id);
    }

    @PutMapping("/{id}")
    public Clinic updateClinic(@PathVariable Long id, @RequestBody Clinic updatedClinic) {
        return clinicService.updateClinic(id, updatedClinic);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
    }

    @PostMapping("/{clinicId}/doctors")
    public Doctor addDoctorToClinic(@PathVariable Long clinicId, @RequestBody Doctor doctor) {
        return clinicService.addDoctorToClinic(clinicId, doctor);
    }

    @PostMapping("/{clinicId}/patients")
    public Patient addPatientToClinic(@PathVariable Long clinicId, @RequestBody Patient patient) {
        return clinicService.addPatientToClinic(clinicId, patient);
    }

    @GetMapping("/{clinicId}/doctors")
    public List<Doctor> getDoctorsInClinic(@PathVariable Long clinicId) {
        return clinicService.getDoctorsInClinic(clinicId);
    }

    @GetMapping("/{clinicId}/patients")
    public List<Patient> getPatientsInClinic(@PathVariable Long clinicId) {
        return clinicService.getPatientsInClinic(clinicId);
    }

    @PostMapping("/{clinicId}/doctorId")
    public Doctor addDoctorToClinicById(@PathVariable Long clinicId, @RequestBody Long doctorId) {
        return clinicService.addDoctorToClinicById(clinicId, doctorId);
    }

    @PostMapping("/{clinicId}/patientId")
    public Patient addPatientToClinicById(@PathVariable Long clinicId, @RequestBody Long patientId) {
        return clinicService.addPatientToClinicById(clinicId, patientId);
    }

}
