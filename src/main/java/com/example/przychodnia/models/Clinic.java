package com.example.przychodnia.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phone;
    private String email;
    @OneToMany
    private List<Patient> patientList;
    @OneToMany
    private List<Doctor> doctorList;

}