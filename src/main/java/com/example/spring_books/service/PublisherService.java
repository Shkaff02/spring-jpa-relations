package com.example.spring_books.service;

import com.example.spring_books.model.Publisher;
import com.example.spring_books.repository.AuthorRepository;
import com.example.spring_books.repository.PublisherRepository;
import org.hibernate.type.StringNVarcharType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository repository;
    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public Publisher savePublisher(Publisher publisher) {
        return repository.save(publisher);
    }

    public List<Publisher> saveAllPublishers(List<Publisher> publishers) {
        return repository.saveAll(publishers);
    }

    public List<Publisher> getPublishers(){
        return repository.findAll();
    }

    public Publisher getPublisherById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Publisher getPublisherByName(String name) {
        return repository.findByName(name);
    }

    public List<Publisher> getPublishersByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<Publisher> getPublishersByCity(String city) {
        return repository.findAllByCity(city);
    }

    public Publisher getPublisherByAddress(String address) {
        return repository.findByAddress(address);
    }

    public Publisher updatePublisher(Publisher publisher) {
        Publisher updatedPublisher = repository.findById(publisher.getId()).orElse(null);
        updatedPublisher.setCity(publisher.getCity());
        updatedPublisher.setCountry(publisher.getCountry());
        updatedPublisher.setAddress(publisher.getAddress());
        updatedPublisher.setName(publisher.getName());
        updatedPublisher.setBooks(publisher.getBooks());
        return repository.save(updatedPublisher);
    }

    public String deletePublisher(int id) {
        repository.deleteById(id);
        return "Publisher #" + id + " was deleted!";
    }

}
