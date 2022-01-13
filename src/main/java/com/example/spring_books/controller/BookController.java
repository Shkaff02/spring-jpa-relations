package com.example.spring_books.controller;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import com.example.spring_books.service.AuthorService;
import com.example.spring_books.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    private final BookService service;
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PostMapping("/book/many")
    public List<Book> saveBooks(@RequestBody List<Book> books) {
        return service.saveBooks(books);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @GetMapping("/book/name/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return service.getBooksByName(name);
    }

    @GetMapping("/book/date/{date}")
    public List<Book> getBooksByCreationDate(@PathVariable Date date){
        return service.getBooksByCreationDate(date);
    }

    @GetMapping("/book/pages/{pages}")
    public List<Book> getBooksByPages(@PathVariable int pages) {
        return service.getBooksByPages(pages);
    }

    @GetMapping("/book/author/{id}")
    public String findBookNameByAuthor(@PathVariable int id) {
        return service.findBookNameByAuthor(id);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @PutMapping("book/{book_id}/author/{author_id}")
    public Book assignBookToAuthor(@PathVariable int book_id, @PathVariable int author_id) {
        return service.addBookToAuthor(author_id, book_id);
    }

    @PutMapping("book/{book_id}/publisher/{publisher_id}")
    public Book assignBookToPublisher(@PathVariable int book_id, @PathVariable int publisher_id) {
        return service.addBookToPublisher(publisher_id, book_id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
}
