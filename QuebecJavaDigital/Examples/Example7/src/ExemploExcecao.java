import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao {
    public static void main(String[] args) {
        Number valor = Double.valueOf("a1.75");
        System.out.println(valor);

        Number outro_valor;
        try {
            outro_valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(outro_valor);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
}
