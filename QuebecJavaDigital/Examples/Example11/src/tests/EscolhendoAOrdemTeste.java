package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
// @TestMethodOrder(MethodOrderer.MethodName.class)
// @TestMethodOrder(MethodOrderer.Random.class)
public class EscolhendoAOrdemTeste {
    
    @DisplayName("A")
    @Order(4)
    @Test
    public void validaFluxoA() {}

    @DisplayName("B")
    @Order(3)
    @Test
    public void validaFluxoB() {}

    @DisplayName("C")
    @Order(2)
    @Test
    public void validaFluxoC() {}

    @DisplayName("D")
    @Order(1)
    @Test
    public void validaFluxoD() {}
}
