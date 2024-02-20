package com.example.przychodnia.services;

import com.example.przychodnia.models.Visit;
import com.example.przychodnia.repository.VisitRepository;
import com.example.przychodnia.services.interfaces.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public Visit getVisitById(Long id) {
        return visitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + id));
    }

    @Override
    public Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Visit updateVisit(Long id, Visit visit) {
        if (!visitRepository.existsById(id)) {
            throw new RuntimeException("Visit not found with id: " + id);
        }
        visit.setId(id);
        return visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
