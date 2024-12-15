package com.epam.backend.core.cleancode.library;

import com.epam.backend.core.cleancode.library.service.impl.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LibrarySystem {

    private final LibraryService libraryService;
    private final Logger log = LoggerFactory.getLogger(getClass());


    public LibrarySystem(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    public void checkOutBook(String bookId, String userId) {
        try {
                libraryService.checkOutBook(bookId, userId);
            } catch  (IllegalArgumentException | UnsupportedOperationException ex) {
                log.error("Unsuccessful check out operation: {}", ex.getMessage());
            }

    }


    public void returnBook(String bookId) {
        try {
            libraryService.returnBook(bookId);
        } catch  (IllegalArgumentException | UnsupportedOperationException ex) {
            log.error("Unsuccessful book return operation: {}", ex.getMessage());
        }
    }


    public void reserveBook(String bookId, String userId) {
        try {
            libraryService.reserveBook(bookId, userId);
        } catch  (IllegalArgumentException | UnsupportedOperationException ex) {
            log.error("Unsuccessful book reservation operation: {}", ex.getMessage());
        }
    }
}

