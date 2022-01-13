package com.example.spring_books.repository;

import com.example.spring_books.model.Author;
import com.example.spring_books.model.Reward;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Integer> {
    List<Reward> findAllByName(String name);

}
