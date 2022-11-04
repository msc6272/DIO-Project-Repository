import java.util.Arrays;
import java.util.List;
import java.util.Set;
//import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
//import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

public class ExercicioStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
            Arrays.asList("1","0","4","1","2","3","9","9","6","5");
        System.out.println("Imprimir todos os elementos da lista de Strings");
        // Using Anonymous Function 
        /*numerosAleatorios.stream().forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
            
        });*/
        
        // Using Lambda 
        /*numerosAleatorios.stream().forEach(s -> System.out.println(s));*/
        
        // Using Lambda even more simplified
        /*numerosAleatorios.forEach(s -> System.out.println(s));*/

        // Using Reference Method
        numerosAleatorios.forEach(System.out :: println);

        System.out.println("Inserir os 5 primeiros números em um novo Set");
        // Printing the elements of a disposable Set from a List
        /*
        numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet())
            .forEach(System.out :: println);
        */
        Set<String> collectSet = numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet());
        System.out.println(collectSet);
        
        System.out.println("Transformar a lista de String em lista de Integer");
        // Using Functional Interface 
        /*numerosAleatorios.stream()
            .map(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return Integer.parseInt(s);
                }
            })
            .forEach(System.out :: println);*/
        
        // Using Lambda
        /*numerosAleatorios.stream()
            .map(s -> Integer.parseInt(s))
            .forEach(System.out :: println);*/
        
        // Using Reference Method
        List<Integer> collectList = numerosAleatorios.stream()
            .map(Integer :: parseInt)
            .collect(Collectors.toList());
        
        System.out.println(collectList);

        System.out.println("Insira os números pares maiores que 2 para uma nova lista");
        // Using Functional Interface 
        /*List<Integer> ListaParesMaioresQueDois = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(new Predicate<Integer>() {
                @Override
                public boolean test(Integer i) {
                    if (i % 2 == 0 && i > 2) return true;
                    return false;
                }
            })
            .collect(Collectors.toList());*/

        // Using Lambda 
        List<Integer> ListaParesMaioresQueDois = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> i % 2 == 0 && i > 2)
            .collect(Collectors.toList());
        System.out.println(ListaParesMaioresQueDois);

        System.out.println("Mostrar a média dos números");
        // Functional Interface 
        numerosAleatorios.stream()
            .mapToInt(new ToIntFunction<String>() {
                @Override
                public int applyAsInt(String s) {
                    return Integer.parseInt(s);
                }
            })
            .average()
            .ifPresent(new DoubleConsumer() {
                @Override
                public void accept(double value) {
                    System.out.println(value);
                }
            });

        // Lambda 
        numerosAleatorios.stream()
            .mapToInt(s -> Integer.parseInt(s))
            .average()
            .ifPresent(v -> System.out.println(v));

        // Reference Method 
        numerosAleatorios.stream()
            .mapToInt(Integer :: parseInt)
            .average()
            .ifPresent(System.out :: println);

        System.out.println("Remover os valores ímpares");
        List<Integer> listaNumerosInteiros = numerosAleatorios.stream()
            .map(Integer :: parseInt)
            .collect(Collectors.toList());
        // Functional Interface 
        listaNumerosInteiros.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                if (t % 2 != 0) return true;
                return false;
            }
        });
        // Lambda
        listaNumerosInteiros.removeIf(t -> t % 2 != 0);
        System.out.println(listaNumerosInteiros);
    }
}
