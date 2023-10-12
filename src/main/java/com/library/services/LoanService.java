package com.library.services;

import com.library.domain.Loan;
import com.library.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan> findAll() {
        return repository.findAll();
    }

    public Loan findById(Long id) {
        Optional<Loan> obj = repository.findById(id);
        return obj.get();
    }
}
