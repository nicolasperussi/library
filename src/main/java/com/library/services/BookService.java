package com.library.services;

import com.library.domain.Book;
import com.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Book> obj = repository.findById(id);
        return obj.get();
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Book update(Long id, Book book) {
        Book entity = repository.getReferenceById(id);
        updateData(entity, book);
        return repository.save(entity);
    }

    private void updateData(Book entity, Book obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setAuthor(obj.getAuthor());
        entity.setAvailableAmount(obj.getAvailableAmount());
    }
}
