package com.example.leetcodeclone.web;

import com.example.leetcodeclone.model.Submission;
import com.example.leetcodeclone.service.ProblemService;
import com.example.leetcodeclone.service.SubmissionService;
import com.example.leetcodeclone.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubmissionPageController {

    private final SubmissionService submissionService;
    private final UserService userService;
    private final ProblemService problemService;

    public SubmissionPageController(SubmissionService submissionService,
                                    UserService userService,
                                    ProblemService problemService) {
        this.submissionService = submissionService;
        this.userService = userService;
        this.problemService = problemService;
    }

    @GetMapping("/submissions")
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        Page<Submission> submissions = submissionService.list(PageRequest.of(page, size));
        model.addAttribute("submissions", submissions);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "submissions";
    }

    @GetMapping("/submissions/new")
    public String newForm(Model model) {
        model.addAttribute("submission", new Submission());
        model.addAttribute("users", userService.listAll());
        model.addAttribute("problems", problemService.listAll());
        model.addAttribute("mode", "create");
        return "submission-form";
    }

    @PostMapping("/submissions")
    public String create(@ModelAttribute Submission submission) {
        submissionService.create(submission);
        return "redirect:/submissions";
    }
}
