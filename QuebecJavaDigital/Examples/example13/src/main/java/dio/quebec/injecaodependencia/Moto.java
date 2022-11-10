package dio.quebec.injecaodependencia;

public class Moto implements Veiculo {
    @Override
    public void acao() {
        System.out.println("É uma moto.");
    }
}
