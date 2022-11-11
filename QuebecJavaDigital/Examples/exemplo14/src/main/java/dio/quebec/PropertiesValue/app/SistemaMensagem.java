package dio.quebec.PropertiesValue.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner{
    @Value("${nome:NoReply-DIO}") // caso não encontre a chave 'nome' usa o valor depois dos ':'
    private String nome;
    @Value("${email}")
    private String email;
    @Value("${telefone}")
    private List<Long> telefone;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: " + nome + 
            "\nE-mail: " + email + 
            "\nCom telefones para contato: " + telefone);
        System.out.println("Seu cadastro foi aprovado");
    }
}
