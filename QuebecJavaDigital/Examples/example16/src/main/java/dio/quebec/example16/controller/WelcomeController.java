package dio.quebec.example16.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    // Ver documentação do Spring Boot sobre segurança
    // https://docs.spring.io/spring-security/site/docs/5.0.2.RELEASE/reference/htmlsingle/#access-control-using-preauthorize-and-postauthorize 
    @GetMapping("/users")
    // A linha abaixo foi desabilitada para implementar via ADAPTER 
    // @PreAuthorize("hasAnyRole('MANAGER','USER')")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/managers")
    // A linha abaixo foi desabilitada para implementar via ADAPTER 
    // @PreAuthorize("hasRole('MANAGER')")
    public String managers() {
        return "Authorized manager";
    }

    @GetMapping("/teste")
    public String teste() {
        return "Teste de página sem controle de acesso";
    }
}
