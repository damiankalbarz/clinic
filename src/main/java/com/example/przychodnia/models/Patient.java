package com.example.przychodnia.models;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Patient extends Person {
    private List<Prescription> prescriptionList;

}
