package com.example.spring_books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date creationDate;
    private int pages;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    public void assignAuthor(Author author) {
        this.author = author;
    }

    public void assignPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
