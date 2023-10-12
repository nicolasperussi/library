package com.library.domain.dtos;

import com.library.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Document is required")
    @Size(min = 9, max = 10, message = "The document must be a CPF or RG")
    private String document;

    public User toUser() {
        return new User(null, name, document);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
