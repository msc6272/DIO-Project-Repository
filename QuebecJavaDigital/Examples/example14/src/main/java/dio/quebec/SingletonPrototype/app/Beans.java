package dio.quebec.SingletonPrototype.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean 
    // O padrão é o escopo 'singleton'. Caso queira o escopo 'prototype', descomente a linha abaixo.
    //@Scope("prototype") 
    public Remetente remetente() {
        System.out.println("CRIANDO UM OBJETO REMETENTE");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");
        remetente.setNome("Ditial Innovation One");
        return remetente;
    }
}
