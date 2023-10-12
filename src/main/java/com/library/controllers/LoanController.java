package com.library.controllers;

import com.library.domain.Loan;
import com.library.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {
    @Autowired
    private LoanService service;

    @GetMapping
    public ResponseEntity<List<Loan>> findAll() {
        List<Loan> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Loan> findById(@PathVariable Long id) {
        Loan loan = service.findById(id);
        return ResponseEntity.ok().body(loan);
    }

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody Loan loan) {
        Loan newLoan = service.create(loan);
        return ResponseEntity.status(201).body(newLoan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
