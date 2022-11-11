package dio.quebec.BeansComponents;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dio.quebec.BeansComponents.app.ConversorJson;
import dio.quebec.BeansComponents.app.ViaCepResponse;

// import com.google.gson.Gson;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner run(ConversorJson conversor) throws Exception {
        return args -> {
            String json = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"localidade\": \"São Paulo\"}";
            ViaCepResponse response = conversor.converter(json);
            System.out.println("Dados do CEP: " + response);
        };
    }

    /*
     * A forma abaixo seria uma forma de transformar uma classe que não temos controle (Gson)
     * em um possível objeto que pode ser referenciado por @Bean, isto é, cujo controle estaria
     * sob o 'comando' do Spring Boot, podendo ser injetado em qualquer parte da Aplicação.
     * Não é a melhor forma de resolver o problema, caso existam muitos casos iguais.
     * A melhor forma seria criar uma Bean Factory (arquivo BeanFactory.java)
     */ 

    /* @Bean
    public Gson gson() {
        return new Gson();
    } */
}
