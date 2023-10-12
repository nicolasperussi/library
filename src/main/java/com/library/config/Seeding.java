package com.library.config;

import com.library.domain.Book;
import com.library.domain.Loan;
import com.library.domain.User;
import com.library.repositories.BookRepository;
import com.library.repositories.LoanRepository;
import com.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Configuration
public class Seeding implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book(null, "Livro 1", "Autor 1", "Descrição 1", 5);
        Book b2 = new Book(null, "Livro 2", "Autor 2", "Descrição 2", 3);
        Book b3 = new Book(null, "Livro 3", "Autor 3", "Descrição 3", 7);
        Book b4 = new Book(null, "Livro 4", "Autor 4", "Descrição 4", 2);
        Book b5 = new Book(null, "Livro 5", "Autor 5", "Descrição 5", 6);
        Book b6 = new Book(null, "Livro 6", "Autor 6", "Descrição 6", 4);
        Book b7 = new Book(null, "Livro 7", "Autor 7", "Descrição 7", 9);
        Book b8 = new Book(null, "Livro 8", "Autor 8", "Descrição 8", 1);
        Book b9 = new Book(null, "Livro 9", "Autor 9", "Descrição 9", 8);
        Book b10 = new Book(null, "Livro 10", "Autor 10", "Descrição 10", 10);

        User u1 = new User(null, "Rafael", "11155577700");
        User u2 = new User(null, "Paulo", "22266688800");
        User u3 = new User(null, "Júlia", "33377799900");

        Loan l1 = new Loan(null, u1, 15);
        l1.getBooks().add(b8);

        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10));
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        loanRepository.save(l1);
    }
}
