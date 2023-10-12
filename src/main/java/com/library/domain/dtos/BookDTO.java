package com.library.domain.dtos;

import com.library.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class BookDTO {
    @NotBlank(message = "Book name is required")
    private String name;
    @NotBlank(message = "Author name is required")
    private String author;
    @NotBlank(message = "Book description is required")
    private String description;
    @PositiveOrZero(message = "The available must be a number greater than or equal to zero")
    private Integer availableAmount;

    public Book toBook() {
        return new Book(null, name, author, description, availableAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }
}
