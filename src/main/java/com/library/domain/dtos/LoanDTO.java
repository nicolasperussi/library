package com.library.domain.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoanDTO {
    @NotNull(message = "User ID is required")
    public Long userId;
    @NotNull(message = "Book IDs are required")
    @Size(min = 1, message = "You must provide at least one Book ID")
    public Long[] bookIds;
    @NotNull(message = "Days is required")
    @Min(value = 7, message = "A loan has a minimum of 7 days")
    @Max(value = 30, message = "A loan has a maximum of 30 days")
    public Integer days;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(Long[] bookIds) {
        this.bookIds = bookIds;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
