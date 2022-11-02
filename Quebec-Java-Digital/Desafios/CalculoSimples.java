import java.util.Scanner;

public class CalculoSimples {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
		
        int cod1 = leitor.nextInt();
        int n1 = leitor.nextInt();
        double valor1 = leitor.nextDouble();

        int cod2 = leitor.nextInt();
        int n2 = leitor.nextInt();
        double valor2 = leitor.nextDouble();

        if (cod1 % cod1 !=0 ) System.err.println(cod1);
        if (cod2 % cod2 !=0 ) System.err.println(cod2);
          
  // TODO: Implemente um Cálculo Simples. 
  // Levando em consideração a sua precedência de operadores e a definição de suas casas decimais:
          
       double total = (n1 * valor1) + (n2 * valor2);
       System.out.println(String.format("VALOR A PAGAR: R$ %.2f", total));

       leitor.close();
    }
}
