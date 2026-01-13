package com.example.leetcodeclone.repository;

import com.example.leetcodeclone.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
