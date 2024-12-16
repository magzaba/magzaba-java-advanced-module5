package com.epam.backend.core.cleancode.library.dto;

import java.util.Objects;

public class Book {
    private final String bookId;
    private final String author;
    private final String title;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, title);
    }
}
