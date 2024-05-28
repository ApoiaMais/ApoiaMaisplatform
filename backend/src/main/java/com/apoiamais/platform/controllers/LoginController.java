package com.apoiamais.platform.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apoiamais.platform.entities.User;
import com.apoiamais.platform.services.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o nome da página HTML que contém o formulário de login
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = userService.findByEmailAndPassword(email, password);
        if (user!= null) {
            if (user.hasRole("ROLE_ADMIN")) {
                return "redirect:/tela-psicologo";
            } else if (user.hasRole("ROLE_CLIENT")) {
                return "redirect:/tela-paciente";
            }
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/tela-psicologo")
    public String telaPsicologo() {
        return "tela-psicologo";
    }

    @GetMapping("/tela-paciente")
    public String telaPaciente() {
        return "tela-paciente";
    }
}


