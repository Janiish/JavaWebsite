package com.example.leetcodeclone.web;

import com.example.leetcodeclone.model.Problem;
import com.example.leetcodeclone.service.ProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProblemPageController {

    private final ProblemService problemService;

    public ProblemPageController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/problems")
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        Page<Problem> problems = problemService.list(PageRequest.of(page, size));
        model.addAttribute("problems", problems);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "problems";
    }

    @GetMapping("/problems/new")
    public String newForm(Model model) {
        model.addAttribute("problem", new Problem());
        model.addAttribute("mode", "create");
        return "problem-form";
    }

    @PostMapping("/problems")
    public String create(@ModelAttribute Problem problem) {
        problemService.create(problem);
        return "redirect:/problems";
    }

    @GetMapping("/problems/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("problem", problemService.get(id));
        model.addAttribute("mode", "edit");
        return "problem-form";
    }

    @PostMapping("/problems/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Problem patch) {
        problemService.update(id, patch);
        return "redirect:/problems";
    }

    @PostMapping("/problems/{id}/delete")
    public String delete(@PathVariable Long id) {
        problemService.delete(id);
        return "redirect:/problems";
    }
}
