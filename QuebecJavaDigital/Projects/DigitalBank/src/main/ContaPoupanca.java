package main;

public class ContaPoupanca extends Conta {
    // Poderíamos mover SEQUENCIAL para a classe Conta, 
    // caso as classes filhas fossem compartilhar o mesmo sequencial
    
    /*
     * Por fim, decidiu-se mover a criação da conta para a classe-pai. 
     
    private static int SEQUENCIAL = 1;

    public ContaPoupanca() {
        super.agencia = Conta.AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }
    */

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato () {
        System.out.println("*** Extrato Conta Poupança ***");
        super.imprimirInfoComum();
    }
}
