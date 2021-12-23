package com.example.spring_books.controller;

import com.example.spring_books.model.Publisher;
import com.example.spring_books.service.AuthorService;
import com.example.spring_books.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {
    private final PublisherService service;
    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        return service.savePublisher(publisher);
    }

    @PostMapping("/savePublishers")
    public List<Publisher> savePublishers(@RequestBody List<Publisher> publishers) {
        return service.saveAllPublishers(publishers);
    }

    @GetMapping("/publishers")
    public List<Publisher> getPublishers(){
        return service.getPublishers();
    }

    @GetMapping("/publisherById/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return service.getPublisherById(id);
    }

    @GetMapping("/publisherByName/{name}")
    public Publisher getPublishersByName(@PathVariable String name) {
        return service.getPublisherByName(name);
    }

    @GetMapping("/publishersByCountry/{country}")
    public List<Publisher> getPublishersByCountry(@PathVariable String country) {
        return service.getPublishersByCountry(country);
    }

    @GetMapping("/publishersByCity/{city}")
    public List<Publisher> getPublishersByCity(@PathVariable String city) {
        return service.getPublishersByCity(city);
    }

    @GetMapping("/publisherByAddress/{address}")
    public Publisher getPublishersByAddress(@PathVariable String address) {
        return service.getPublisherByAddress(address);
    }

    @PutMapping("/updatePublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return service.updatePublisher(publisher);
    }

    @DeleteMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable int id) {
        return service.deletePublisher(id);
    }
}
