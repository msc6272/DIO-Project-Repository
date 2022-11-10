package dio.quebec.example13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Em XML seria: <bean id="livro" class="dio.quebec.example13" /> 
    @Bean
    public Livro getLivro() {
        return new Livro();
    }

    @Bean
    public AutorLivro getAutorLivro() {
        return new Autor();
    }
}
