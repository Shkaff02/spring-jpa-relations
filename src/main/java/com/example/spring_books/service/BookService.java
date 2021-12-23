package com.example.spring_books.service;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import com.example.spring_books.model.Publisher;
import com.example.spring_books.repository.AuthorRepository;
import com.example.spring_books.repository.BookRepository;
import com.example.spring_books.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    public BookService(BookRepository repository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> saveBooks(List<Book> books) {
        return repository.saveAll(books);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Book> getBooksByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Book> getBooksByCreationDate(Date date) {
        return repository.findAllByCreationDate(date);
    }

    public List<Book> getBooksByPages(int pages) {
        return repository.findAllByPages(pages);
    }

    public Book updateBook(Book book) {
        Book updatedBook = repository.getById(book.getId());
        updatedBook.setPages(book.getPages());
        updatedBook.setName(book.getName());
        updatedBook.setCreationDate(book.getCreationDate());
        updatedBook.setAuthor(book.getAuthor());
        return repository.save(book);
    }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "Book #" + id + " was deleted!";
    }

    public Book addBookToAuthor(int author_id, int book_id) {
        Book book = repository.findById(book_id).orElse(null);
        Author author = authorRepository.findById(author_id).orElse(null);
        book.assignAuthor(author);
        return repository.save(book);
    }

    public Book addBookToPublisher(int publisher_id, int book_id) {
        Book book = repository.findById(book_id).orElse(null);
        Publisher publisher = publisherRepository.findById(publisher_id).orElse(null);
        book.assignPublisher(publisher);
        return repository.save(book);
    }
}
