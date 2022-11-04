import java.util.Scanner;
import java.util.stream.IntStream; 

public class PreenchimentoVetor_2 {
    public static void main(String[] args) {
        int tamanhoVetor = 1000;
        Scanner leitor = new Scanner(System.in); 
        int t = leitor.nextInt(); 
   
// Lembre-se a sequência de valores é de 0 até T-1:
        int[] n = IntStream.iterate(0, x -> (x + 1) % t)
                       .limit(tamanhoVetor)
                       .toArray();
        
        int posicao = 0;
        for (Integer i : n) System.out.println("N[" + posicao++ + "] = " + i);

        leitor.close();
    }
}
