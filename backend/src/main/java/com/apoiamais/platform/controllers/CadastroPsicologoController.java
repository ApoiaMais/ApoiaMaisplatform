package com.apoiamais.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroPsicologoController {

    @GetMapping("/cadastro/psicologo")
    public String exibirFormularioCadastroPsicologo() {
        return "cadastro-psicologo";
    }
}