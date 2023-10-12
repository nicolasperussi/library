package com.library.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "books")
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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