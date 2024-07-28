package com.springrest.bookstore.services;

import com.springrest.bookstore.entities.Book;
import com.springrest.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long bookId) {
        return bookRepository.getOne(bookId);
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(long bookId) {
        Book book = bookRepository.getOne(bookId);
        bookRepository.delete(book);
    }
}
