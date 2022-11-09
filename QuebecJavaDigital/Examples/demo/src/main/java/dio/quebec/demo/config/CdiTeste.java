package dio.quebec.demo.config;

import javax.inject.Named;

@Named
public class CdiTeste {
    public void executaTeste() {
        System.out.println("Executando método via CDI");
    }
}
