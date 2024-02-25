package com.example.przychodnia.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Data i czas wizyty nie mogą być puste")
    private LocalDateTime dateTime;

    @NotNull(message = "Pacjent nie może być pusty")
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @NotNull(message = "Lekarz nie może być pusty")
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @NotNull(message = "Numer pokoju nie może być pusty")
    private String room;
}
