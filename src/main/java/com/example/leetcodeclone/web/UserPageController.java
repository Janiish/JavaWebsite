package com.example.leetcodeclone.web;

import com.example.leetcodeclone.model.User;
import com.example.leetcodeclone.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPageController {

    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        Page<User> users = userService.list(PageRequest.of(page, size));
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "users";
    }

    @GetMapping("/users/new")
    public String newForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("mode", "create");
        return "user-form";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        model.addAttribute("mode", "edit");
        return "user-form";
    }

    @PostMapping("/users/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User patch) {
        userService.update(id, patch);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
