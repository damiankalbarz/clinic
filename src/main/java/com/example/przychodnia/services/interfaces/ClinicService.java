package com.example.przychodnia.services.interfaces;

import com.example.przychodnia.models.Clinic;
import com.example.przychodnia.models.Doctor;
import com.example.przychodnia.models.Patient;
import com.example.przychodnia.models.Tests;

import java.util.List;

public interface ClinicService {
    Clinic saveClinic(Clinic clinic);
    List<Clinic> getAllClinics();

    Clinic getClinicById(Long id);
    Clinic updateClinic(Long id, Clinic clinic);
    void deleteClinic(Long id);
    Doctor addDoctorToClinic(Long clinicId, Doctor doctor);
    Patient addPatientToClinic(Long clinicId, Patient patient);
    List<Doctor> getDoctorsInClinic(Long clinicId);
    List<Patient> getPatientsInClinic(Long clinicId);
    Doctor addDoctorToClinicById(Long clinicId, Long doctorId);
    Patient addPatientToClinicById(Long clinicId, Long patientId);
    List<Doctor> getDoctorsBySpecialization(Long clinicId, String specialization);
    public Clinic addTestToClinic(Long clinicId, Tests test);

}
