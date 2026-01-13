package com.example.leetcodeclone.service;

import com.example.leetcodeclone.model.Submission;
import com.example.leetcodeclone.repository.SubmissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Transactional(readOnly = true)
    public Page<Submission> list(Pageable pageable) { return submissionRepository.findAll(pageable); }

    @Transactional
    public Submission create(Submission s) { return submissionRepository.save(s); }

    @Transactional(readOnly = true)
    public Submission get(Long id) { return submissionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Submission not found")); }

    @Transactional
    public Submission update(Long id, Submission patch) {
        Submission existing = get(id);
        if (patch.getUser() != null) existing.setUser(patch.getUser());
        if (patch.getProblem() != null) existing.setProblem(patch.getProblem());
        if (patch.getCode() != null) existing.setCode(patch.getCode());
        if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
        return submissionRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) { submissionRepository.deleteById(id); }
}
