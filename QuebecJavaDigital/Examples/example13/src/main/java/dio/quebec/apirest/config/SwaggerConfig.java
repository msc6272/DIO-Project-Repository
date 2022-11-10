
// Este programa deve ser utilizado com o Spring Web (servidor Tomcat)
// As dependências não foram definidas
// O projeto está incompleto
// Somente tive acesso a este arquivo 

package dio.quebec.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("dio.quebec.apirest.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(buildApiInfo());
    }
    
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
            .title("API Person")
            .description("REST API Person para gerenciamento de pessoas")
            .version("1.0.0")
            .contact(new Contact("Renan Marques", "github.com/re04nan", null))
            .build();
    }
}
