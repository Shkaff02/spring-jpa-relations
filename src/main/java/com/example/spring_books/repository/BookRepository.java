package com.example.spring_books.repository;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByName(String name);

    List<Book> findAllByCreationDate(Date date);

    List<Book> findAllByPages(int pages);
    @Query("SELECT b.name FROM Book  b WHERE b.author.authorId = ?1")
    String findBookNameByAuthor(int authorId);

//    List<Book> findAllByAuthors(Set<Author> authors);
}
