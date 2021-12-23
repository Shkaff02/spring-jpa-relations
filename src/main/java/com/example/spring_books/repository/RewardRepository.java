package com.example.spring_books.repository;

import com.example.spring_books.model.Reward;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Integer> {
    List<Reward> findAllByName(String name);
}
