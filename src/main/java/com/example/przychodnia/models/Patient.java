package com.example.przychodnia.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    @OneToMany
    private List<Prescription> prescriptionList;

}
