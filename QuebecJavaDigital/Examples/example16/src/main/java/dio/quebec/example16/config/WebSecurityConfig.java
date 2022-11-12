package dio.quebec.example16.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    //As linhas abaixo foram adicionadas para permitir a validação de usuários por um BD. 
    
    @Autowired
    private SecurityDatabaseService securityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    //Aqui termina a implementação da validação de usuários por um BD




    /* Implementação da permissão de acesso às páginas Web através de ADAPTER */ 
    ///@Override
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/managers/**").hasAnyRole("MANAGER")
            .antMatchers("/users/**").hasAnyRole("USER", "MANAGER")
            //.anyRequest().authenticated().and().formLogin()
            //.and().formLogin()
            .and().httpBasic()
            ;
        return http.build();
    }

    /*
     * Vários sites foram buscados para resolver o problema dos métodos DEPRECATED do exemplo:
     * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
     * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
     * https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
     * https://www.baeldung.com/spring-security-multiple-auth-providers
     * https://www.appsdeveloperblog.com/spring-security-in-memory-authentication/
     * https://www.codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated
     * https://www.appsdeveloperblog.com/migrating-from-deprecated-websecurityconfigureradapter/
     */
    
     //A implementação abaixo (dados de usuários em memória) foi removida porque implementamos
     //os dados de usuário através do Spring JPA (arquivo 'SecurityDatabaseService.java')
    
    /*  @Bean
    public UserDetailsService users() {
        //UserBuilder users = User.withDefaultPasswordEncoder()
        UserDetails user = User.builder()
            .username("user")
            .password("{noop}user123")
            .roles("USER")
            .build();
        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}master123")
            .roles("MANAGER")
            .build();
            return new InMemoryUserDetailsManager(user, admin);
    } */
}
