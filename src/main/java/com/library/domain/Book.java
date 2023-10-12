package com.library.domain;

import jakarta.persistence.*;

@Entity(name = "books")
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String author;

    @Column(columnDefinition = "TEXT")
    public String description;

    public Integer availableAmount;

}