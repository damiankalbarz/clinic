package com.example.przychodnia.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 2, max = 50, message = "Imię powinno mieć od 2 do 50 znaków")
    private String name;

    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(min = 2, max = 50, message = "Nazwisko powinno mieć od 2 do 50 znaków")
    private String surname;

    @NotBlank(message = "Numer telefonu nie może być pusty")
    @Pattern(regexp = "\\d{9}", message = "Numer telefonu powinien zawierać 9 cyfr")
    private String phone;

    @NotBlank(message = "Adres email nie może być pusty")
    @Email(message = "Nieprawidłowy format adresu email")
    private String email;

    @NotBlank(message = "Adres nie może być pusty")
    private String address;

    @OneToMany
    private List<Prescription> prescriptionList;

}
