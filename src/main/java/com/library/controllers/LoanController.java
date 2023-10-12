package com.library.controllers;

import com.library.domain.Loan;
import com.library.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
