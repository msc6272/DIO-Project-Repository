package dio.quebec.BeansComponents.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// A anotação abaixo poderá, ou não, ser necessária para o correto funcionamento. 
@Configuration 
public class BeanFactory {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    // Várias outras Beans podem ser criadas neste arquivo. 
}
