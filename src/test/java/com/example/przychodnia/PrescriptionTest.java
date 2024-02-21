package com.example.przychodnia;

import com.example.przychodnia.models.Patient;
import com.example.przychodnia.models.Prescription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrescriptionTest {

    @Test
    void setId() {
        Prescription prescription = new Prescription();
        prescription.setId(1L);
        assertEquals(1L, prescription.getId());
    }

    @Test
    void setPatient() {
        Prescription prescription = new Prescription();
        Patient patient = new Patient();
        patient.setId(1L);
        prescription.setPatient(patient);
        assertEquals(1L, prescription.getPatient().getId());
    }

    @Test
    void setDescription() {
        Prescription prescription = new Prescription();
        prescription.setDescription("Test Description");
        assertEquals("Test Description", prescription.getDescription());
    }
}
