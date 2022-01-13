package com.example.spring_books.service;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import com.example.spring_books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    private final AuthorRepository repository;


    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    public List<Author> saveAuthors(List<Author> authors) {
        return repository.saveAll(authors);
    }

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author addBook(Book book, int authorId) {
        Author author = repository.getById(authorId);
        author.getBooks().add(book);
        return repository.save(author);
    }

    public Author getAuthorById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        return repository.findAllByFirstName(firstName);
    }

    public List<Author>  getAuthorsByLastName(String lastName) {
        return repository.findAllByLastName(lastName);
    }

    public List<Author> getAuthorsByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<Author> getAuthorsBySex(String sex) {
        return repository.findAllBySex(sex);
    }

    public List<Author> getAuthorsByBirth(Date birth) {
        return repository.findAllByDate(birth);
    }

    public Author updateAuthor(Author author) {
        Author updatedAuthor = repository.findById(author.getAuthorId()).orElse(null);
        updatedAuthor.setLastName(author.getLastName());
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setCountry(author.getCountry());
        updatedAuthor.setDate(author.getDate());
        updatedAuthor.setSex(author.getSex());
        return repository.save(updatedAuthor);
    }

    public String deleteAuthor(int id) {
        repository.deleteById(id);
        return "Author #" + id + " was deleted!";
    }

    public String findAuthorInfoById(int id) {
        return repository.findAuthorFullNameById(id);
    }

}
