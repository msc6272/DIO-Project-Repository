package dio.quebec.inversaocontrole;

public class Pedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.gravar();
    }

    private EnviarEmails enviar = EnviarEmails.obterDadosEmail();

    public void gravar() {
        // this.enviar = new EnviarEmails("smtp", "contato@email.com", "senha");
        this.enviar.retornar("Pedido criado!");
    }
}
