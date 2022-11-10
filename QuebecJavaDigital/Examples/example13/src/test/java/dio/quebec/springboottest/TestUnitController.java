package dio.quebec.springboottest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dio.quebec.springboottest.controller.TestController;

public class TestUnitController {
    @Test
    public void testUnit() {
        TestController controller = new TestController();
        String resultado = controller.saudacao("DIO");
        assertEquals("Bem-vindo, DIO", resultado);
    }
}
