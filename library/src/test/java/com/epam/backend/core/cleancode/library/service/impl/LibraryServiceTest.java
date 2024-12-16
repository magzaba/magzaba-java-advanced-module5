package com.epam.backend.core.cleancode.library.service.impl;

import com.epam.backend.core.cleancode.library.dto.Book;
import com.epam.backend.core.cleancode.library.dto.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {
    @Mock
    private BookRepository bookRepository;

    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryService(bookRepository);
    }

    @Test
    void checkOutBookSuccessfully() {
        String bookId = "01";
        String userId = "user1";
        String bookTitle = "Book One";
        String bookAuthor = "Author One";

        when(bookRepository.findBookById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));
        when(bookRepository.findBookTitle(bookId)).thenReturn(bookTitle);

        assertDoesNotThrow(() -> libraryService.checkOutBook(bookId, userId));
        verify(bookRepository).findBookTitle(bookId);
    }

    @Test
    void checkOutBookThrowsExceptionWhenUnavailable() {
        String bookId = "02";
        String userId = "user2";
        String bookTitle = "Book Two";
        String bookAuthor = "Author Two";

        when(bookRepository.findBookById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));
        when(bookRepository.findBookTitle(bookId)).thenReturn(bookTitle);

        libraryService.checkOutBook(bookId, userId);

        assertThrows(UnsupportedOperationException.class, () -> libraryService.checkOutBook(bookId, userId));
    }

    @Test
    void returnBookSuccessfully() {
        String bookId = "01";
        String userId = "user1";
        String bookTitle = "Book One";
        String bookAuthor = "Author One";

        when(bookRepository.findBookById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));
        when(bookRepository.findBookTitle(bookId)).thenReturn(bookTitle);

        libraryService.checkOutBook(bookId, userId);
        assertDoesNotThrow(() -> libraryService.returnBook(bookId));
    }

    @Test
    void returnBookThrowsExceptionWhenNotLoaned() {
        String bookId = "03";

        assertThrows(UnsupportedOperationException.class, () -> libraryService.returnBook(bookId));
    }

    @Test
    void reserveBookSuccessfully() {
        String bookId = "01";
        String userId = "user1";
        String bookTitle = "Book One";
        String bookAuthor = "Author One";

        when(bookRepository.findBookById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));
        when(bookRepository.findBookTitle(bookId)).thenReturn(bookTitle);

        libraryService.checkOutBook(bookId, "anotherUser");

        assertDoesNotThrow(() -> libraryService.reserveBook(bookId, userId));
    }

    @Test
    void reserveBookThrowsExceptionWhenNotAvailable() {
        String bookId = "02";
        String userId = "user2";
        String bookTitle = "Book Two";
        String bookAuthor = "Author Two";

        when(bookRepository.findBookById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));
        when(bookRepository.findBookTitle(bookId)).thenReturn(bookTitle);

        assertThrows(UnsupportedOperationException.class, () -> libraryService.reserveBook(bookId, userId));
    }
}