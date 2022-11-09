package dio.quebec.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.quebec.demo.entity.User;
import dio.quebec.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<String> buscaDadosBanco() {
        List<String> nomes = new ArrayList<>();
        System.out.println("Chamou o método de busca");
        return nomes;
    }

    public void deletaDados() {
        System.out.println("Chamou o delete");
        //userRepository.deleteById(1L);
    }

    public User buscaUsuarioPorId(long id) {
        User user = new User();
        user.setNome("Kaique");
        userRepository.save(user);
        
        return userRepository.findById(id).get();
    }
}
