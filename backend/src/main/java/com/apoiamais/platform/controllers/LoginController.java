package com.apoiamais.platform.controllers;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o nome da página HTML que contém o formulário de login
    }

    @PostMapping
    public ModelAndView login(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        // Configurar as credenciais do cliente e do usuário
        String clientId = "myclientid";
        String clientSecret = "myclientsecret";
        String tokenEndpoint = "http://your-auth-server/token"; // Endpoint de token OAuth2

        // Criar o corpo da solicitação para obter o token de acesso
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", username);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        // Fazer a solicitação HTTP para obter o token de acesso
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(tokenEndpoint, requestEntity, String.class);

        // Verificar se a solicitação foi bem-sucedida e extrair o token de acesso
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String accessToken = responseEntity.getBody();
            // Aqui você pode processar o token de acesso conforme necessário
            return new ModelAndView("redirect:/home"); // Redireciona para a página inicial após o login
        } else {
            // Tratar erros de autenticação, como credenciais inválidas
            return new ModelAndView("redirect:/login?error");
        }
    }
}

