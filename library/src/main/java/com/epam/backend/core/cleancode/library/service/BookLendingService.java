package com.epam.backend.core.cleancode.library.service;

public interface BookLendingService {
    void checkOutBook(String bookId, String userId);
    void returnBook(String bookId);
}
