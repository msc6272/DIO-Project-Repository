/*package local.dio.examples;*/

/*import local.dio.model.Gato;*/

public class ProgramaGato {

    public static void main(String[] args) {
        Gato gato = new Gato("miau", 2, "pink");
        Livros livros = new Livros();

        System.out.println(gato);
        System.out.println(livros);
    }
}

class Livros {
    private String nome;
    private Integer paginas;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getPaginas() {
        return paginas;
    }
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
}
