package com.example.spring_books.repository;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByName(String name);

    List<Book> findAllByCreationDate(Date date);

    List<Book> findAllByPages(int pages);

//    List<Book> findAllByAuthors(Set<Author> authors);
}
