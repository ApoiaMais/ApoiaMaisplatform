package com.apoiamais.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MensagemController {

    @GetMapping("/mensagem")
    public String exibirMensagem(Model model) {
        model.addAttribute("mensagem", "Desculpe pelo transtorno, estamos construindo");
        List<String> pontos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pontos.add(".");
        }
        model.addAttribute("pontos", pontos);
        return "mensagem";
    }
}
