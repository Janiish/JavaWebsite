package com.example.leetcodeclone.web;

import com.example.leetcodeclone.model.Submission;
import com.example.leetcodeclone.service.SubmissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public Page<Submission> list(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return submissionService.list(pageable);
    }

    @PostMapping
    public Submission create(@RequestBody Submission submission) {
        return submissionService.create(submission);
    }

    @GetMapping("/{id}")
    public Submission get(@PathVariable Long id) {
        return submissionService.get(id);
    }

    @PatchMapping("/{id}")
    public Submission update(@PathVariable Long id, @RequestBody Submission patch) {
        return submissionService.update(id, patch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        submissionService.delete(id);
    }
}
