package dio.quebec.BeansComponents.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ConversorJson {
    @Autowired
    // private Gson gson = new Gson(); // Na filosofia do Spring Boot, esta linha não deve ser assim.
    private Gson gson;

    public ViaCepResponse converter(String json) {
        ViaCepResponse response = gson.fromJson(json, ViaCepResponse.class);
        return response;
    }
}
