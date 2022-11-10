package dio.quebec.example13;

public class Autor implements AutorLivro {
    private String nome;

    public void exibirAutor() {
        System.out.println(this.nome);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
