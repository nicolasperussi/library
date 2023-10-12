package com.library.controllers;

import com.library.domain.Book;
import com.library.domain.dtos.BookDTO;
import com.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookDTO book) {
        Book newBook = service.create(book.toBook());
        return ResponseEntity.status(201).body(newBook);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
