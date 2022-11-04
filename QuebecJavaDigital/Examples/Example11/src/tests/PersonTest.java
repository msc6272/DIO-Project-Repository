package tests;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.Person;

/*
 * Para que o JUnit funcionasse, eu tive que:
 * 1) Copiar o arquivo 'junit-platform-console-standalone-1.9.1.jar' para o diretório 'lib' do projeto.
 * 2) Incluir a entrada 'java.test.config' no arquivo '.vscode\settings.json'.
 * Tudo isso foi feito por causa do modo como o projeto foi criado: 'No build tools'. 
 * 
 * Recursos importantes
 * 1) https://code.visualstudio.com/docs/java/java-project
 * 2) https://junit.org/junit5/docs/current/user-guide/#overview-getting-started
 * 3) https://github.com/Microsoft/vscode-java-test/wiki/Run-with-Configuration
 * 4) https://code.visualstudio.com/docs/java/java-testing
 * 5) https://dzone.com/articles/writing-tests-with-junit-5
 * 6) https://www.infoworld.com/article/3662814/review-visual-studio-code-shines-for-java.html
 */

public class PersonTest {
    @Test
    public void validarCalculoDeIdade() {
        Person pessoa = new Person("julia", LocalDate.of(2020, 1, 1));
        Assertions.assertEquals(2, pessoa.getIdade());
    }
}
