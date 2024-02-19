package com.example.przychodnia.services;

import com.example.przychodnia.models.Clinic;
import com.example.przychodnia.models.Doctor;
import com.example.przychodnia.models.Patient;
import com.example.przychodnia.repository.ClinicRepository;
import com.example.przychodnia.services.ClinicService;
import com.example.przychodnia.repository.DoctorRepository;
import com.example.przychodnia.repository.PatientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.clinicRepository = clinicRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }
    @Override
    public Clinic saveClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id).orElse(null);
    }

    @Override
    public Clinic updateClinic(Long id, Clinic updatedClinic) {
        Clinic existingClinic = clinicRepository.findById(id).orElse(null);
        if (existingClinic != null) {
            existingClinic.setAddress(updatedClinic.getAddress());
            existingClinic.setPhone(updatedClinic.getPhone());
            existingClinic.setEmail(updatedClinic.getEmail());
            // Update other fields as needed
            return clinicRepository.save(existingClinic);
        }
        return null;
    }

    @Override
    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }

    @Override
    public Doctor addDoctorToClinic(Long clinicId, Doctor doctor) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        if (clinic != null) {
            List<Doctor> doctorList = clinic.getDoctorList();
            doctorList.add(doctor);
            clinic.setDoctorList(doctorList);
            clinicRepository.save(clinic);
            return doctor;
        }
        return null;
    }

    @Override
    public Patient addPatientToClinic(Long clinicId, Patient patient) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        if (clinic != null) {
            List<Patient> patientList = clinic.getPatientList();
            patientList.add(patient);
            clinic.setPatientList(patientList);
            clinicRepository.save(clinic);
            return patient;
        }
        return null;
    }

    @Override
    public List<Doctor> getDoctorsInClinic(Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        return (clinic != null) ? clinic.getDoctorList() : null;
    }

    @Override
    public List<Patient> getPatientsInClinic(Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        return (clinic != null) ? clinic.getPatientList() : null;
    }
    public Doctor addDoctorToClinicById(Long clinicId, Long doctorId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

        if (clinic != null && doctor != null) {
            List<Doctor> doctorList = clinic.getDoctorList();
            doctorList.add(doctor);
            clinic.setDoctorList(doctorList);
            clinicRepository.save(clinic);
            return doctor;
        }

        return null;
    }

    @Override
    public Patient addPatientToClinicById(Long clinicId, Long patientId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElse(null);
        Patient patient = patientRepository.findById(patientId).orElse(null);

        if (clinic != null && patient != null) {
            List<Patient> patientList = clinic.getPatientList();
            patientList.add(patient);
            clinic.setPatientList(patientList);
            clinicRepository.save(clinic);
            return patient;
        }

        return null;
    }
}
