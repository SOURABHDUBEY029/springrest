package com.springrest.bookstore.controller;

import com.springrest.bookstore.entities.Book;
import com.springrest.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private BookService bookService;
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    //get all books
    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getBooks();
    }

    //get single book
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable String bookId){
        return this.bookService.getBook(Long.parseLong(bookId));
    }

    //add a book
    //@PostMapping(path="/books", consumes="application/json")
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    //update a book
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        return this.bookService.updateBook(book);
    }

    //delete a book
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookId){
        try{
            this.bookService.deleteBook(Long.parseLong(bookId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
