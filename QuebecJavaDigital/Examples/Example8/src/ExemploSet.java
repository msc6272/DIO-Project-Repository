import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Criar um conjunto e adicionar as notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,8d,3.6));
        System.out.println(notas.toString());

        System.out.println("Conferir se a nota 5.0 está no conjunto: " + notas.contains(5d));

        System.out.println("Exibir a menor nota: " + Collections.min(notas));

        System.out.println("Exibir a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exibir a soma dos valores: " + soma);

        System.out.println("Exibir a média das nota: " + soma/notas.size());

        System.out.println("Remover a nota 0");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remover as notas menores que 7 e exibir a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exibir todas as notas na ordem em que foram informadas");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(8d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exibir todas as notas na ordem crescente");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apagar todo o conjunto");
        notas.clear();
        System.out.println("Conferir se o conjunto 1 está vazio: " + notas.isEmpty());
        System.out.println("Conferir se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Conferir se o conjunto 3 está vazio: " + notas3.isEmpty());
    }
}
