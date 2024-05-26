package com.apoiamais.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apoiamais.platform.entities.User;
import com.apoiamais.platform.repositories.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "cadastro";
    }

	@PostMapping("/cadastro")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastro";
        }

        userRepository.save(user);
        model.addAttribute("message", "Usuário cadastrado com sucesso!");
        return "redirect:/";
    }
}
