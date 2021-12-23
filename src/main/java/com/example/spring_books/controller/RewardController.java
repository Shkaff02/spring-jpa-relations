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

    @PostMapping("/saveReward")
    public Reward saveReward(@RequestBody Reward reward) {
        return service.saveReward(reward);
    }

    @PostMapping("/saveRewards")
    public List<Reward> saveReward(@RequestBody List<Reward> rewards) {
        return service.saveRewards(rewards);
    }

    @GetMapping("/rewards")
    public List<Reward> getRewards() {
        return service.getRewards();
    }

    @GetMapping("/rewardById/{id}")
    public Reward getRewardById(@PathVariable int id) {
        return service.getRewardById(id);
    }

    @GetMapping("/rewardByName/{name}")
    public List<Reward> getRewardByName(@PathVariable String  name) {
        return service.getRewardsByName(name);
    }

    @PutMapping("/updateReward")
    public Reward updateReward(@RequestBody Reward reward) {
        return service.updateReward(reward);
    }

    @PutMapping("author/{author_id}/reward/{reward_id}")
    public Reward assignRewardToAuthor(@PathVariable int author_id, @PathVariable int reward_id) {
        return service.addRewardToAuthor(author_id, reward_id);
    }

    @DeleteMapping("/deleteReward/{id}")
    public String deleteReward(@PathVariable int id) {
        return service.deleteReward(id);
    }
}
