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

    @PostMapping("/publisher")
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        return service.savePublisher(publisher);
    }

    @PostMapping("/publisher/many")
    public List<Publisher> savePublishers(@RequestBody List<Publisher> publishers) {
        return service.saveAllPublishers(publishers);
    }

    @GetMapping("/publisher/all")
    public List<Publisher> getPublishers(){
        return service.getPublishers();
    }

    @GetMapping("/publisher/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return service.getPublisherById(id);
    }

    @GetMapping("/publisher/name/{name}")
    public Publisher getPublishersByName(@PathVariable String name) {
        return service.getPublisherByName(name);
    }

    @GetMapping("/publisher/country/{country}")
    public List<Publisher> getPublishersByCountry(@PathVariable String country) {
        return service.getPublishersByCountry(country);
    }

    @GetMapping("/publisher/city/{city}")
    public List<Publisher> getPublishersByCity(@PathVariable String city) {
        return service.getPublishersByCity(city);
    }

    @GetMapping("/publisher/address/{address}")
    public Publisher getPublishersByAddress(@PathVariable String address) {
        return service.getPublisherByAddress(address);
    }

    @PutMapping("/publisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return service.updatePublisher(publisher);
    }

    @DeleteMapping("/publisher/{id}")
    public String deletePublisher(@PathVariable int id) {
        return service.deletePublisher(id);
    }
}
