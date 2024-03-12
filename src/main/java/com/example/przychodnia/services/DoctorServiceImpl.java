package com.example.przychodnia.services;

import com.example.przychodnia.config.KafkaTopicConfig;
import com.example.przychodnia.models.Doctor;
import com.example.przychodnia.repository.DoctorRepository;
import com.example.przychodnia.services.interfaces.DoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTopicConfig kafkaTopicConfig;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public void sendDoctor(Doctor doctor) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String reqJson = mapper.writeValueAsString(doctor);
            kafkaTemplate.send(kafkaTopicConfig.productTopic().name(), reqJson);
        }catch (Exception e){
            e.printStackTrace();

        }

    }
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
