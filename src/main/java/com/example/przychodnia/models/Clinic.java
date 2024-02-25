package com.example.przychodnia.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pole adres nie może być puste")
    @Size(min = 2, max = 50, message = "Pole adres powinno mieć od 2 do 50 znaków")
    private String address;

    @NotBlank(message = "Numer telefonu nie może być pusty")
    @Pattern(regexp = "\\d{9}", message = "Numer telefonu powinien zawierać 9 cyfr")
    private String phone;

    @NotBlank(message = "Adres email nie może być pusty")
    @Email(message = "Nieprawidłowy format adresu email")
    private String email;

    @OneToMany
    private List<Patient> patientList;
    @OneToMany
    private List<Doctor> doctorList;
    @OneToMany
    private List<Tests> testsList;


    public void addTest(Tests test) {
        if (testsList == null) {
            testsList = new ArrayList<>();
        }
        testsList.add(test);
    }
}
