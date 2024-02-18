package com.example.przychodnia.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    private String specialization;
    private String diagram;




}
