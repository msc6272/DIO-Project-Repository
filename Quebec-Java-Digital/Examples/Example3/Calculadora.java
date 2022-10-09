/* package ###.###.###; */

import java.util.Scanner;

import javax.print.event.PrintJobListener;

public class Calculadora {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;

        System.out.println("Digite o primeiro valor: ");
        a = scan.nextInt();
        System.out.println("Digite o segundo valor: ");
        b = scan.nextInt();
        
        int soma = soma(a, b);
        int subtracao = subtracao(a, b);
        int multiplicacao = multiplicacao(a, b);
        double divisao = divisao(a, b);
        
        System.out.println("soma: " + soma);
        System.out.println("subtração: " + subtracao);
        System.out.println("multiplicação: " + multiplicacao);
        System.out.println("divisão: " + divisao);
    }

    public static int soma(int a, int b) {
        return a + b;
    }

    public static int subtracao(int a, int b) {
        return a - b;
    }

    public static int multiplicacao(int a, int b) {
        return a * b;
    }

    /* This is very disturbing: it should be enough to use 'double' as the return value; which is not
     * I have to define the parameters as 'double' in order to get a 'double' value
     * Good info: https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
     */
    public static double divisao(double a, int b) {
        return a / b;
    }
}
