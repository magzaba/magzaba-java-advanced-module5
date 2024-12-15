package com.epam.backend.core.cleancode.library.dto.repository;

import com.epam.backend.core.cleancode.library.dto.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookRepository {
    private final List<Book> booksRegistry = new CopyOnWriteArrayList<>();

    public void addBook(Book book){
        if(!booksRegistry.contains(book)){
            booksRegistry.add(book);
        } else {
            throw new UnsupportedOperationException(String.format("Book with id %s already in the registry.", book.getBookId()));
        }
    }

    public void addBooks(List<Book> books){
        books.forEach(this::addBook);
    }

    public Book findBookById(String bookId){
        return booksRegistry.stream()
                .filter(book -> bookId.equals(book.getBookId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No book with id %s in the library", bookId)));
    }

    public String findBookTitle(String bookId){
        return findBookById(bookId).getTitle();
    }

}
