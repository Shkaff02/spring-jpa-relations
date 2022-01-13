package com.example.spring_books.repository;

import com.example.spring_books.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByFirstName(String name);

    List<Author> findAllByLastName(String lastName);

    List<Author> findAllByCountry(String country);

    List<Author> findAllBySex(String sex);

    List<Author> findAllByDate(Date birth);
    @Query(value = "SELECT a.firstName, a.lastName FROM Author a WHERE a.authorId = ?1")
    String findAuthorFullNameById(int authorId);
}
