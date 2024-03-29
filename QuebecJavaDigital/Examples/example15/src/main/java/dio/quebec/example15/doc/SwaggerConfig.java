package dio.quebec.example15.doc;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato() {
        return new Contact(
            "Seu nome",
            "http://www.seusite.com.br",
            "voce@seusite.com.br"
        );
    }

    private ApiInfoBuilder informacoesApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Title - Rest API");
        apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Sua Empresa");
        apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
            .select()
            .apis(RequestHandlerSelectors.basePackage("dio.quebec.example15.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.informacoesApi().build())
            .consumes(new HashSet<String>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

    // O problema de não exibir a interface do Swagger foi resolvido com essa dica:
    // https://github.com/springfox/springfox/issues/3462#issuecomment-1123580724 
    // Basta chamar o site na url: http://localhost:8080/swagger-ui/ 
    @RequestMapping("/")
    public String home() {
        //return "redirect:swagger-ui.html"; --old
        return "redirect:swagger-ui/";
    }
}
