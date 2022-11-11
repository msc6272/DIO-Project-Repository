package dio.quebec.exemplo14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exemplo14Application {

	public static void main(String[] args) {
		SpringApplication.run(Exemplo14Application.class, args);

		/*
		 * Os dois comandos abaixo estão em desacordo com a filosofia do Spring Boot.
		 * No Spring Boot, a instanciação é feita automaticamente, através das anotações
		 * no código e conforme a necessidade do aplicativo.
		 * Por isso estão comentadas, por causa da implementação correta em MyApp.java e Calculadora.java
		 */
		//Calculadora calculadora = new Calculadora();
		//System.out.println("O resultado é: " + calculadora.somar(2, 7));
	}

}
