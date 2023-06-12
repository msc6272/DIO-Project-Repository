package dio.bootcamp.tqi.kotlin.creditrequestsystem.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springdoc.core.models.GroupedOpenApi

@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        // verificar junto à documentação o que mais pode ser feito com o SpringDoc
        return GroupedOpenApi.builder()
            .group("springcreditrequestsystem-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}