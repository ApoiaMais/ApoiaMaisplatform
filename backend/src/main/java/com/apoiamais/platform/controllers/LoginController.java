package com.apoiamais.platform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o nome da página HTML que contém o formulário de login
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        // Lógica de autenticação aqui (pode ser via Spring Security)
        // Se o login for bem-sucedido, redirecionar para tela-psicologo.html
        return "redirect:/tela-psicologo";
    }

    @GetMapping("/tela-psicologo")
    public String telaPsicologo() {
        return "tela-psicologo";
    }
}


