package com.example.przychodnia;

import com.example.przychodnia.models.Prescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrescriptionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllPrescriptions() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prescriptions"))
                .andExpect(status().isOk())
                .andReturn();

        // Sprawdź, czy otrzymałeś listę recept
        assertEquals(2, objectMapper.readValue(result.getResponse().getContentAsString(), List.class).size());
    }

    @Test
    void testGetPrescriptionById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prescriptions/1"))
                .andExpect(status().isOk())
                .andReturn();

        // Sprawdź, czy otrzymałeś receptę o określonym ID
        assertEquals("Opis recepty 1", objectMapper.readValue(result.getResponse().getContentAsString(), Prescription.class).getDescription());
    }

    @Test
    void testAddPrescription() throws Exception {
        Prescription prescription = new Prescription();
        prescription.setDescription("Test Description");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/prescriptions")
                .content(objectMapper.writeValueAsString(prescription))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Sprawdź, czy otrzymałeś dodaną receptę
        assertEquals("Test Description", objectMapper.readValue(result.getResponse().getContentAsString(), Prescription.class).getDescription());
    }

    @Test
    void testUpdatePrescription() throws Exception {
        Prescription prescription = new Prescription();
        prescription.setDescription("Updated Description");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/prescriptions/1")
                .content(objectMapper.writeValueAsString(prescription))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Sprawdź, czy otrzymałeś zaktualizowaną receptę
        assertEquals("Updated Description", objectMapper.readValue(result.getResponse().getContentAsString(), Prescription.class).getDescription());
    }

    @Test
    void testDeletePrescription() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/prescriptions/1"))
                .andExpect(status().isOk());

        // Sprawdź, czy recepta została usunięta
    }
}
