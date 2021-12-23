package com.example.spring_books.controller;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import com.example.spring_books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author) {
        return service.saveAuthor(author);
    }

    @PostMapping("/saveAuthors")
    public List<Author> saveAuthors(@RequestBody List<Author> authors) {
        return service.saveAuthors(authors);
    }

    @PostMapping("/addBook/{id}")
    public Author addBook(@PathVariable int id, @RequestBody Book book) {
        return service.addBook(book, id);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return service.getAuthors();
    }

    @GetMapping("/authorById/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return service.getAuthorById(id);
    }

    @GetMapping("/authorByFirstName/{firstName}")
    public List<Author> getAuthorsByFirstName(@PathVariable String firstName) {
        return service.getAuthorsByFirstName(firstName);
    }

    @GetMapping("/authorByLastName/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable String lastName) {
        return service.getAuthorsByLastName(lastName);
    }

    @GetMapping("/authorByCountry/{country}")
    public List<Author> getAuthorsByCountry(@PathVariable String country) {
        return service.getAuthorsByCountry(country);
    }

    @GetMapping("/authorBySex/{sex}")
    public List<Author> getAuthorsBySex(@PathVariable String sex) {
        return service.getAuthorsBySex(sex);
    }

    @GetMapping("/authorByBirth/{birth}")
    public List<Author> getAuthorsByBirth(@PathVariable Date birth) {
        return service.getAuthorsByBirth(birth);
    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author) {
        return service.updateAuthor(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable int id) {
        return service.deleteAuthor(id);
    }
}
