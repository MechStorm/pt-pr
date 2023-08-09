package com.example.spring_boot_exp.controllers;

import com.example.spring_boot_exp.model.User;
import com.example.spring_boot_exp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!(userService.createUser(user))) {
            model.addAttribute("errUser", "User with \"" + user + "\" email is already exists");
            return "registration";
        }
        return "redirect:/login";
    }
}
