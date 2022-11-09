package dio.quebec.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    @Scope("singleton") // usar com escopos 'singleton', 'prototype', 'application' ou 'websocket' 
    // @RequestScope // usar com escopo 'request' 
    // @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) // exemplo do escopo 'application' 
    // @SessionScope // usar com escopo 'session' 
    // @Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS) // exemplo do escopo 'websocket' 
    public BeanTeste beanTeste() {
        return new BeanTeste();
    }

/*     @Bean
    public UserRepository userRepository() {
        System.out.println("Iniciando");

        return new UserRepository();
    } */
}
