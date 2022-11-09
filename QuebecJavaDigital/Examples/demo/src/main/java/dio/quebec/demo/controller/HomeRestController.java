package dio.quebec.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.quebec.demo.entity.User;
import dio.quebec.demo.service.UserService;

@RestController
public class HomeRestController {
    @Autowired
    private UserService service;

    @RequestMapping("/rest")
    public User testeRest() {
        return service.buscaUsuarioPorId(1L);
    }

}
