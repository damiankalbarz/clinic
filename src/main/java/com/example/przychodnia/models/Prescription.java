package com.example.przychodnia.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;
    private String description;
}
