package com.library.services;

import com.library.domain.Book;
import com.library.exceptions.DatabaseException;
import com.library.exceptions.ResourceNotFoundException;
import com.library.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find book with id " + id));
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        try {
            Book book = this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find book with id " + id));
            repository.delete(book);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Book update(Long id, Book book) {
        try {
            Book entity = repository.getReferenceById(id);
            updateData(entity, book);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Couldn't find book with id " + id);
        }
    }

    private void updateData(Book entity, Book obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setAuthor(obj.getAuthor());
        entity.setAvailableAmount(obj.getAvailableAmount());
    }
}
