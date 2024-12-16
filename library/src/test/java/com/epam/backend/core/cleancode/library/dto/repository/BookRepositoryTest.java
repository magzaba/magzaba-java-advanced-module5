package com.epam.backend.core.cleancode.library.dto.repository;

import com.epam.backend.core.cleancode.library.dto.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BookRepositoryTest {
    private BookRepository bookRepository;
    private static Book book1 = new Book("01", "Book One", "Author One");
    private static Book book2 = new Book("02", "Book Two", "Author Two");

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void addBookSuccessfully() {
        assertDoesNotThrow(() -> bookRepository.addBook(book1));
    }

    @Test
    void addBookThrowsExceptionWhenBookAlreadyExists() {
        bookRepository.addBook(book1);
        assertThrows(UnsupportedOperationException.class, () -> bookRepository.addBook(book1));
    }

    @Test
    void addBooksSuccessfully() {
        List<Book> books = Arrays.asList(book1, book2);
        assertDoesNotThrow(() -> bookRepository.addBooks(books));
        assertEquals("Book One", bookRepository.findBookTitle("01"));
        assertEquals("Book Two", bookRepository.findBookTitle("02"));
    }

    @Test
    void findBookByIdSuccessfully() {
        bookRepository.addBook(book1);
        Book foundBook = bookRepository.findBookById("01");
        assertNotNull(foundBook);
        assertEquals("Book One", foundBook.getTitle());
    }

    @Test
    void findBookByIdThrowsExceptionWhenNotFound() {
        assertThrows(IllegalArgumentException.class, () -> bookRepository.findBookById("03"));
    }

    @Test
    void findBookTitleSuccessfully() {
        bookRepository.addBook(book1);
        String title = bookRepository.findBookTitle("01");
        assertEquals("Book One", title);
    }

    @Test
    void findBookTitleThrowsExceptionWhenNotFound() {
        assertThrows(IllegalArgumentException.class, () -> bookRepository.findBookTitle("03"));
    }

}