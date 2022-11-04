package main;

import java.util.logging.Logger;

public class BancoDeDados {
    
    private static final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());
    
    public static void iniciarConexao() {
        // fez algo
        LOGGER.info("Inicializou conexão");
    }

    public static void finalizarConexao() {
        // fez algo
        LOGGER.info("Finalizou conexão");
    }

    public static void alteraDados(Pessoa pessoa) {
        // altera dados no BD
        LOGGER.info("Alterou dados no BD");
    }
}
