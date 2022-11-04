package main;

public class ContaCorrente extends Conta {
    // private static int SEQUENCIAL = 1;

    /* 
     * Decidiu-se mover a criação da conta para a classe-pai
    
    public ContaCorrente() {
        super.agencia = Conta.AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }
     */

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato () {
        System.out.println("*** Extrato Conta Corrente ***");
        imprimirInfoComum();
    }


}
