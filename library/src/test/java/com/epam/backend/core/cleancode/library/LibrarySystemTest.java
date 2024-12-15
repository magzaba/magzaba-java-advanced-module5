package com.epam.backend.core.cleancode.library;

import com.epam.backend.core.cleancode.library.service.impl.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LibrarySystemTest {
    @Mock
    private LibraryService libraryService;

    private LibrarySystem librarySystem;

    @BeforeEach
    void setUp() {
        librarySystem = new LibrarySystem(libraryService);
    }

    @Test
    void checkOutBookSuccessfully() {
        String bookId = "01";
        String userId = "user1";

        doNothing().when(libraryService).checkOutBook(bookId, userId);

        librarySystem.checkOutBook(bookId, userId);

        verify(libraryService).checkOutBook(bookId, userId);
    }

    @Test
    void checkOutBookThrowsExceptionWhenUnsuccessful() {
        String bookId = "01";
        String userId = "user1";
        UnsupportedOperationException exception = new UnsupportedOperationException("Book is unavailable");

        doThrow(exception).when(libraryService).checkOutBook(bookId, userId);

        librarySystem.checkOutBook(bookId, userId);

        verify(libraryService).checkOutBook(bookId, userId);
    }

    @Test
    void returnBookSuccessfully() {
        String bookId = "01";

        doNothing().when(libraryService).returnBook(bookId);

        librarySystem.returnBook(bookId);

        verify(libraryService).returnBook(bookId);
    }

    @Test
    void returnBookThrowsExceptionWhenUnsuccessful() {
        String bookId = "01";
        UnsupportedOperationException exception = new UnsupportedOperationException("Book not on loan");

        doThrow(exception).when(libraryService).returnBook(bookId);

        librarySystem.returnBook(bookId);

        verify(libraryService).returnBook(bookId);
    }

    @Test
    void reserveBookSuccessfully() {
        String bookId = "01";
        String userId = "user1";

        doNothing().when(libraryService).reserveBook(bookId, userId);

        librarySystem.reserveBook(bookId, userId);

        verify(libraryService).reserveBook(bookId, userId);
    }

    @Test
    void reserveBookThrowsExceptionWhenUnsuccessful() {
        String bookId = "01";
        String userId = "user1";
        UnsupportedOperationException exception = new UnsupportedOperationException("Book cannot be reserved");

        doThrow(exception).when(libraryService).reserveBook(bookId, userId);

        librarySystem.reserveBook(bookId, userId);

        verify(libraryService).reserveBook(bookId, userId);
    }
}