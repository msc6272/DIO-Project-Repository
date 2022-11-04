package tests;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
/*
 * Também podemos importar todos métodos Assertions.
 * Daí, não precisamos inserir a palavra Assertions antes dos métodos.
 * Por exemplo:
 * import org.junit.jupiter.api.Assertions.*;
 * 
 * assertNotNull(pessoa);
 */

import main.Pessoa;

public class AssertionsTest {
    @Test
    public void validarLancamentos() {
        int[] primeiroLancamento = {10, 20, 30, 40, 50};
        int[] segundoLancamento = {-1, 5, 2, 3, 10, 16, 17};
        int[] terceiroLancamento = {10, 20, 30, 40, 50};

        Assertions.assertArrayEquals(primeiroLancamento, terceiroLancamento);
        Assertions.assertNotEquals(primeiroLancamento, segundoLancamento);
    }

    @Test
    public void validarSeObjetoEstaNulo() {
        Pessoa pessoa = null;
        Assertions.assertNull(pessoa);

        pessoa = new Pessoa("Luciano", LocalDateTime.now());
        Assertions.assertNotNull(pessoa);
    }

    @Test
    public void validarNumerosDeTiposDiferentes() {
        double valor = 5.0;
        double outroValor = 5.0;
        Assertions.assertEquals(valor, outroValor);
    }
}
