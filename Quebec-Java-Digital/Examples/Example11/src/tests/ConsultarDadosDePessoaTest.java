package tests;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.BancoDeDados;
import main.Pessoa;

public class ConsultarDadosDePessoaTest {
    @BeforeAll
    static void configuraConexao() {
        BancoDeDados.iniciarConexao();
        System.out.println("rodou configuraConexão");
    }

    @BeforeEach
    public void insereDadosParaTeste() {
        BancoDeDados.alteraDados(new Pessoa("João", 
            LocalDateTime.of(200,1,1,13,0,0)));
    }

    @AfterEach
    public void removeDadosDoTeste() {
        BancoDeDados.alteraDados(new Pessoa("João", 
            LocalDateTime.of(200,1,1,13,0,0)));
    }

    @Test
    public void validarDadosDeRetorno() {
        Assertions.assertTrue(true);
    }

    @Test
    public void validarDadosDeRetorno2() {
        Assertions.assertNull(null);
    }

    @AfterAll
    static void finalizarConexao() {
        BancoDeDados.finalizarConexao();
        System.out.println("rodou finalizarConexao");
    }
}
