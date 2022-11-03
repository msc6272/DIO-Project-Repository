package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

public class AssumptionsTeste {
    
    @Test
    void validarAlgoSomenteNoUsuarioWillyan() {
        Assumptions.assumeTrue("willyan".equals(System.getenv("USER")));
        Assumptions.assumeTrue("root".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5 + 5);
    }
}
