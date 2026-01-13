package com.example.leetcodeclone.service;

import com.example.leetcodeclone.model.Problem;
import com.example.leetcodeclone.repository.ProblemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class ProblemService {
    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Transactional(readOnly = true)
    public Page<Problem> list(Pageable pageable) { return problemRepository.findAll(pageable); }

    @Transactional
    public Problem create(Problem p) { return problemRepository.save(p); }

    @Transactional(readOnly = true)
    public Problem get(Long id) { return problemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Problem not found")); }

    @Transactional
    public Problem update(Long id, Problem patch) {
        Problem existing = get(id);
        if (patch.getTitle() != null) existing.setTitle(patch.getTitle());
        if (patch.getDescription() != null) existing.setDescription(patch.getDescription());
        if (patch.getDifficulty() != null) existing.setDifficulty(patch.getDifficulty());
        return problemRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) { problemRepository.deleteById(id); }
}
