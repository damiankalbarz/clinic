package com.example.przychodnia.repository;

import com.example.przychodnia.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Dodaj dodatkowe metody, jeśli są wymagane
}
