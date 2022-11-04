package Exceptions;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

public class UncheckedException {
    public static void main(String[] args) {
        // https://plantuml.com/en/faq#239d64f675c3e515
        // https://www.oracle.com/technical-resources/articles/javase/headless.html 
        // System.setProperty("java.awt.headless", "true");

        boolean continueLooping = true;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 

        do {
            if (ge.isHeadlessInstance()) {
                System.out.println("Deu Merda!");
                // Implementar a leitura das variáveis na janela de Terminal 
                continueLooping = false;
            } else {
                String a = JOptionPane.showInputDialog("Numerador: ");
                String b = JOptionPane.showInputDialog("Denominador: ");

                try {
                    int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                    System.out.println("Resultado: " + resultado);
                    continueLooping = false;
                } catch (Exception e) {
                    // e.printStackTrace();
                    if (e instanceof NumberFormatException) 
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Informe um número inteiro!\n" + e.getMessage());
                    if (e instanceof ArithmeticException)
                    JOptionPane.showMessageDialog(null, "Impossível dividir um número por zero!\n" + e.getMessage());
                } finally {
                    System.out.println("Chegou ao FINALLY!");
                }

                System.out.println("O código continua...");
            }
        } while (continueLooping);        
    }

    public static int dividir(int a, int b) {
        return a/b;
    }
}
