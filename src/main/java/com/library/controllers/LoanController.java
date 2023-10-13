package com.library.controllers;

import com.library.domain.Book;
import com.library.domain.Loan;
import com.library.domain.User;
import com.library.domain.dtos.LoanDTO;
import com.library.services.BookService;
import com.library.services.LoanService;
import com.library.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {
    @Autowired
    private LoanService service;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

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
    public ResponseEntity<Loan> create(@Valid @RequestBody LoanDTO loanDTO) {
        Long userId = loanDTO.getUserId();
        User user = userService.findById(userId);

        Loan newLoan = new Loan(null, user, loanDTO.getDays());

        Long[] bookIds = loanDTO.getBookIds();
        for (Long bookId : bookIds) {
            Book book = bookService.findById(bookId);
            newLoan.getBooks().add(book);
        }

        newLoan = service.create(newLoan);

        for (Long bookId : bookIds) {
            Book book = bookService.findById(bookId);
            book.setAvailableAmount(book.getAvailableAmount() - 1);
            bookService.update(bookId, book);
        }

        return ResponseEntity.status(201).body(newLoan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
