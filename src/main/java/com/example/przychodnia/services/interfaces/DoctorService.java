package com.example.przychodnia.services.interfaces;

import com.example.przychodnia.models.Doctor;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    Doctor saveDoctor(Doctor doctor);

    void deleteDoctor(Long id);
    void sendDoctor(Doctor doctor) throws JsonProcessingException;


}
