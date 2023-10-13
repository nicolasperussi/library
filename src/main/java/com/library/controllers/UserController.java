package com.library.controllers;

import com.library.domain.Book;
import com.library.domain.User;
import com.library.domain.dtos.UserDTO;
import com.library.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/document/{document}")
    public ResponseEntity<User> findById(@PathVariable String document) {
        User user = service.findByDocument(document);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        User newUser = service.create(userDTO.toUser());
        return ResponseEntity.status(201).body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
