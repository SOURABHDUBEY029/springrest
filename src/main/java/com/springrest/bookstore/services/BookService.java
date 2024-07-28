package com.springrest.bookstore.services;

import com.springrest.bookstore.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();

    public Book getBook(long bookId);

    public Book addBook(Book book);

    public Book updateBook(Book book);

    public void deleteBook(long bookId);
}
