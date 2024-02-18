package com.example.przychodnia.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;
    private String room;
}
