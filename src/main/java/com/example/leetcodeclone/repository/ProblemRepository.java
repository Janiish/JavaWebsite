package com.example.leetcodeclone.repository;

import com.example.leetcodeclone.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
