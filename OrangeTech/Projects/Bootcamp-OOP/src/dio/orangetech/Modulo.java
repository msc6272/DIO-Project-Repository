package dio.orangetech;

import java.util.LinkedHashSet;
import java.util.Set;

public class Modulo {
    private String nome;
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }
    
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
