package dio.orangetech;

public class Skill {
    private String nome;
    private String categoria; // hard skill, soft skill
    private String subCategoria; // linguagem de programação, banco de dados, inteligência emocional (ou o tipo do skill relacionado a soft skills)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }
    
    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }
}
