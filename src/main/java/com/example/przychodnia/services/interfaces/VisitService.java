package com.example.przychodnia.services.interfaces;

import com.example.przychodnia.models.Visit;

import java.util.List;

public interface VisitService {

    List<Visit> getAllVisits();

    Visit getVisitById(Long id);

    Visit addVisit(Visit visit);

    Visit updateVisit(Long id, Visit visit);

    void deleteVisit(Long id);
}
