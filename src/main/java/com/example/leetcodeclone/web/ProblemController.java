package com.example.leetcodeclone.web;

import com.example.leetcodeclone.model.Problem;
import com.example.leetcodeclone.service.ProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public Page<Problem> list(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return problemService.list(pageable);
    }

    @PostMapping
    public Problem create(@RequestBody Problem problem) {
        return problemService.create(problem);
    }

    @GetMapping("/{id}")
    public Problem get(@PathVariable Long id) {
        return problemService.get(id);
    }

    @PatchMapping("/{id}")
    public Problem update(@PathVariable Long id, @RequestBody Problem patch) {
        return problemService.update(id, patch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        problemService.delete(id);
    }
}
