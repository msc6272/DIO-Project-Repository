package dio.quebec.SpringDataJpa;

import dio.quebec.SpringDataJpa.model.Users;
import dio.quebec.SpringDataJpa.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartAppAlternative implements CommandLineRunner{
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        List<Users> users = repository.filtrarPorNome("GLEYSON");
        for(Users u: users) {
            System.out.println(u);
        }
    }

    private void insertUser() {
        // A classe não pode se chamar User, pois dá conflito com o H2 
        // Ver outra observação MUITO IMPORTANTE no arquivo Users.java 
        Users usuario = new Users();
        usuario.setName("GABRIEL NUNES");
        usuario.setUsername("gabriel");
        usuario.setPassword("santos");
        repository.save(usuario);

        for (Users u: repository.findAll()) {
            System.out.println(u);
        }
    }
}
