package com.example.spring_books.service;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Book;
import com.example.spring_books.model.Reward;
import com.example.spring_books.repository.AuthorRepository;
import com.example.spring_books.repository.BookRepository;
import com.example.spring_books.repository.PublisherRepository;
import com.example.spring_books.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class RewardService {
    private final RewardRepository repository;
    private final AuthorRepository authorRepository;
    public RewardService(RewardRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public Reward saveReward(Reward reward) {
        return repository.save(reward);
    }

    public List<Reward> saveRewards(List<Reward> rewards) {
        return  repository.saveAll(rewards);
    }

    public List<Reward> getRewards() {
        return repository.findAll();
    }

    public Reward getRewardById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Reward> getRewardsByName(String name) {
        return repository.findAllByName(name);
    }

    public Reward updateReward(Reward reward) {
        Reward updatedReward = repository.findById(reward.getId()).orElse(null);
        updatedReward.setName(reward.getName());
        updatedReward.setDescription(reward.getDescription());
        updatedReward.setAuthor(reward.getAuthor());
        return repository.save(updatedReward);
    }

    public String deleteReward(int id) {
        repository.deleteById(id);
        return "Reward #" + id + " was deleted!";
    }

    public Reward addRewardToAuthor(int author_id, int reward_id) {
        Reward reward = repository.findById(reward_id).orElse(null);
        Author author = authorRepository.findById(author_id).orElse(null);
        reward.assignAuthor(author);
        return repository.save(reward);
    }

}
