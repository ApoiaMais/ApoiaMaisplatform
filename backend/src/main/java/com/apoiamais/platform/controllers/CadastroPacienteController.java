package com.apoiamais.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroPacienteController {

    @GetMapping("/cadastro/paciente")
    public String exibirFormularioCadastroPaciente() {
        return "cadastro-paciente";
    }
}