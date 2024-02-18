package com.example.przychodnia.controllers;

import com.example.przychodnia.models.Visit;
import com.example.przychodnia.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public ResponseEntity<List<Visit>> getAllVisits() {
        List<Visit> visits = visitService.getAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable Long id) {
        Visit visit = visitService.getVisitById(id);
        return new ResponseEntity<>(visit, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Visit> addVisit(@RequestBody Visit visit) {
        Visit addedVisit = visitService.addVisit(visit);
        return new ResponseEntity<>(addedVisit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visit> updateVisit(@PathVariable Long id, @RequestBody Visit visit) {
        Visit updatedVisit = visitService.updateVisit(id, visit);
        return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
