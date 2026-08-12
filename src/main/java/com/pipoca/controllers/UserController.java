package com.pipoca.controllers;

import com.pipoca.models.User;
import com.pipoca.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping
    public String listagem(Model model){
        model.addAttribute("users",repository.findAll());
        return "users";
    }

    @PostMapping
    public String gravar(@ModelAttribute User user){
        repository.save(user);
        return "redirect:/users";
    }
}
