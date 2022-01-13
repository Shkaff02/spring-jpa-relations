package com.example.spring_books.controller;

import com.example.spring_books.model.Book;
import com.example.spring_books.model.Reward;
import com.example.spring_books.service.BookService;
import com.example.spring_books.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RewardController {
    private final RewardService service;
    public RewardController(RewardService service) {
        this.service = service;
    }

    @PostMapping("/reward")
    public Reward saveReward(@RequestBody Reward reward) {
        return service.saveReward(reward);
    }

    @PostMapping("/reward/many")
    public List<Reward> saveReward(@RequestBody List<Reward> rewards) {
        return service.saveRewards(rewards);
    }

    @GetMapping("/reward/all")
    public List<Reward> getRewards() {
        return service.getRewards();
    }

    @GetMapping("/reward/{id}")
    public Reward getRewardById(@PathVariable int id) {
        return service.getRewardById(id);
    }

    @GetMapping("/reward/name/{name}")
    public List<Reward> getRewardByName(@PathVariable String  name) {
        return service.getRewardsByName(name);
    }

    @PutMapping("/reward")
    public Reward updateReward(@RequestBody Reward reward) {
        return service.updateReward(reward);
    }

    @PutMapping("author/{author_id}/reward/{reward_id}")
    public Reward assignRewardToAuthor(@PathVariable int author_id, @PathVariable int reward_id) {
        return service.addRewardToAuthor(author_id, reward_id);
    }

    @PutMapping("book/{book_id}/reward/{reward_id}")
    public Reward assignRewardToBook(@PathVariable int book_id, @PathVariable int reward_id) {
        return service.addRewardToBook(book_id, reward_id);
    }

    @PutMapping("publisher/{publisher_id}/reward/{reward_id}")
    public Reward assignRewardToPublisher(@PathVariable int publisher_id, @PathVariable int reward_id) {
        return service.addRewardToPublisher(publisher_id, reward_id);
    }

    @DeleteMapping("/reward/{id}")
    public String deleteReward(@PathVariable int id) {
        return service.deleteReward(id);
    }
}
