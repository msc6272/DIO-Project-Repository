import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoLista {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("Exibir pela ordem de inserção");
        System.out.println(meusGatos);

        System.out.println("Exibir em ordem aleatória");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Exibir em ordem por NOME"); // Que diabos quer dizer isso?
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Exibir em ordem por IDADE");
        Collections.sort(meusGatos, new ComparatorIdade());
        // Também poderíamos usar
        // meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("Exibir em ordem por COR");
        meusGatos.sort(new ComparatorCor());
        // Também poderíamos usar
        // Collections.sort(meusGatos, new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("Exibir em ordem por NOME/COR/IDADE");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato> { 
    private String nome;
    private Integer idade;
    private String cor;
    
    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    @Override
    public String toString() {
        return "{" +
            "nome='" + nome + '\'' +
            ", idade=" + idade +
            ", cor='" + cor + '\'' +
            '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato gato1, Gato gato2) {
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        if (nome != 0) return nome;

        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}