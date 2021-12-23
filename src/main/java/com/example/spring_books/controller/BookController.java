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

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PostMapping("/saveBooks")
    public List<Book> saveBooks(@RequestBody List<Book> books) {
        return service.saveBooks(books);
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @GetMapping("/getBooksByName/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return service.getBooksByName(name);
    }

    @GetMapping("/getBooksByDate/{date}")
    public List<Book> getBooksByCreationDate(@PathVariable Date date){
        return service.getBooksByCreationDate(date);
    }

    @GetMapping("/getBooksByPages/{pages}")
    public List<Book> getBooksByPages(@PathVariable int pages) {
        return service.getBooksByPages(pages);
    }

    @PutMapping("/updateBook")
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

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
}
