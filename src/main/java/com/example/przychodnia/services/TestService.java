package com.example.przychodnia.services;

import com.example.przychodnia.models.Tests;
import com.example.przychodnia.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Tests> getAllTests() {
        return testRepository.findAll();
    }

    public Optional<Tests> getTestById(Long id) {
        return testRepository.findById(id);
    }

    public Tests createTest(Tests test) {
        return testRepository.save(test);
    }

    public Tests updateTest(Long id, Tests updatedTest) {
        if (testRepository.existsById(id)) {
            updatedTest.setId(id);
            return testRepository.save(updatedTest);
        } else {
            // Obsługa przypadku, gdy test o podanym ID nie istnieje
            return null;
        }
    }

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
