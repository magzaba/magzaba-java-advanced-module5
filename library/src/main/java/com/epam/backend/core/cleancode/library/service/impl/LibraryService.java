package com.epam.backend.core.cleancode.library.service.impl;

import com.epam.backend.core.cleancode.library.dto.repository.BookRepository;
import com.epam.backend.core.cleancode.library.service.BookLendingService;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.epam.backend.core.cleancode.library.service.BookReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryService implements BookLendingService, BookReservationService {

    private final Map<String, String> loanedBooksRegistry = new ConcurrentHashMap<>();
    private final Map<String, String> reservedBooks = new ConcurrentHashMap<>();
    private final BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void checkOutBook(String bookId, String userId) {
        var bookTitle = bookRepository.findBookTitle(bookId);
        if(isAvailable (bookId)){
            loanedBooksRegistry.put(bookId, userId);
            log.info("Book: {} checked out to user {}", bookTitle, userId);
            if (reservedBooks.containsKey(bookId)){
                reservedBooks.remove(bookId);
                log.info("Reservation of the book: {} for the user {} released.", bookId, userId);
            }
        } else {
            throw new UnsupportedOperationException(String.format("Book: %s is currently unavailable.", bookTitle));
        }
    }

    private boolean isAvailable(String bookId) {
        return Objects.nonNull(bookRepository.findBookById(bookId))
                && !loanedBooksRegistry.containsKey(bookId);
    }

    @Override
    public void returnBook(String bookId) {
        if(loanedBooksRegistry.containsKey(bookId)) {
            loanedBooksRegistry.remove(bookId);
            log.info("Book: {} returned.", bookRepository.findBookTitle(bookId));
        } else {
            throw new UnsupportedOperationException(String.format("Book with id: %s is not on loan - cannot be returned.", bookId));
        }
    }

    @Override
    public void reserveBook(String bookId, String userId) {
        var bookTitle = bookRepository.findBookTitle(bookId);
        if(bookCanBeReserved(bookId)){
            reservedBooks.put(bookId, userId);
            log.info("Book: {} reserved for the user {}", bookTitle, userId);
        } else {
            throw new UnsupportedOperationException(String.format("Book: %s cannot be currently reserved.", bookTitle));
        }
    }

    private boolean bookCanBeReserved(String bookId) {
        return Objects.nonNull(bookRepository.findBookById(bookId))
                && loanedBooksRegistry.containsKey(bookId)
                && !reservedBooks.containsKey(bookId);
    }

}
