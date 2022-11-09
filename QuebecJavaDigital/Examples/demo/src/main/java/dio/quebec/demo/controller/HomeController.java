package dio.quebec.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dio.quebec.demo.config.BeanTeste;
import dio.quebec.demo.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private BeanTeste teste1;

    @Autowired
    private BeanTeste teste2;

    @RequestMapping("/")
    public String home(Model model) {
        userService.buscaDadosBanco();
        userService.deletaDados();

        teste1.setNome("Bean teste 1");
        System.out.println(teste1.getNome());
        System.out.println(teste2.getNome());

        model.addAttribute("mensagem", "Hello World");
        return "home";
    }
}
