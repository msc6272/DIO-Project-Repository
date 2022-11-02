package HerancaUpcastDowncast;

public class App {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        // Upcast 
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();

        // Downcast 
        // Gerente gerente_ = new Funcionario(); // Esta linha gera erro
        // Vendedor vendedor_ = (Vendedor) new Funcionario(); // Gera erro: "(HerancaUpcastDowncast.Funcionario and HerancaUpcastDowncast.Vendedor are in unnamed module of loader 'app')"
    }
}
