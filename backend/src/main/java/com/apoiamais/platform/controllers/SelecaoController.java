package com.apoiamais.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SelecaoController {

    @GetMapping("/selecao")
    public ModelAndView selecionarTipoUsuario() {
        ModelAndView modelAndView = new ModelAndView("selecao");
        return modelAndView;
    }

    @PostMapping("/cadastro-psicologo")
    public ModelAndView cadastroPsicologo() {
        return new ModelAndView("redirect:/cadastro-psicologo");
    }

    @PostMapping("/cadastro-paciente")
    public ModelAndView cadastroPaciente() {
        return new ModelAndView("redirect:/cadastro-paciente");
    }
}