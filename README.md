# Apoia Mais (Apoia+)

Apoia Mais é um projeto que oferece consultas psicológicas gratuitas ou a baixo custo (valor social) voltado especialmente para o público LGBT+. O psicólogo poderá se cadastrar, o paciente também, e o paciente passará por uma avaliação social para verificar suas condições de pagamento. As consultas serão realizadas online.

## Funcionalidades

- Cadastro de psicólogos
- Cadastro de pacientes
- Avaliação social dos pacientes
- Agendamento de consultas online
- Plataforma de consultas online

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA/Hibernate
- Spring Security
- Spring validation
- ReactJS
- Thymeleaf
- Swagger/OpenAPI

## Instalação

Para rodar o projeto localmente, siga os passos abaixo:

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/apoia-mais.git
    cd apoia-mais
    ```

2. Configure o banco de dados no arquivo `application.yml`:

    ```yaml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/apoia_mais
        username: root
        password: password
      jpa:
        hibernate:
          ddl-auto: update
    ```

3. Rode a aplicação:

    ```bash
    ./mvnw spring-boot:run
    ```

## Uso

Após rodar a aplicação, a API estará disponível em `http://localhost:8080`. Utilize as rotas para interagir com o sistema:

- `POST /psychologists` - Cadastro de psicólogos
- `POST /patients` - Cadastro de pacientes
- `POST /assessments` - Avaliação social
- `GET /consultation` - Listar consultas
- `POST /consultation` - Agendar consulta

Você pode acessar a documentação da API no endpoint `/swagger-ui.html`.

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commite suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Faça um push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Se você tiver alguma dúvida ou sugestão, entre em contato:

- Nome: Antoy Guilherme
- Email: antonygcabral@gmail.com
- LinkedIn: [linkedin](https://linkedin.com/in/antony-guilherme)

- Nome: Guilherme Davino
- Email: guilherme.1009@hotmail.com
- LinkedIn: [linkedin](https://linkedin.com/in/guilherme-albuquerque-davino)

# Em andamento testes de software
- testes unitarios e de integração com junit
- cobertura de testes com jaccoco
- testes de api com mockmvc e restAssured
- cadastro de usuario encriptados
- front-end typescript(TS), reactJS e Axios

- # Modelo conceitual

![final-conceitual](https://github.com/ApoiaMais/ApoiaMaisplatform/assets/51931679/74401f08-702a-4d2a-a59a-095cc391e7e5)



