package com.example.spring_books.repository;

import com.example.spring_books.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Publisher findByName(String name);

    List<Publisher> findAllByCountry(String country);

    List<Publisher> findAllByCity(String city);

    Publisher findByAddress(String address);
}
