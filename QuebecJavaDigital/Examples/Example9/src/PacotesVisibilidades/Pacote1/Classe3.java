package PacotesVisibilidades.Pacote1;

public class Classe3 {
    // Como Classe3 não estende nenhuma classe, então só pode acessar os métodos e atributos de uma classe
    // depois de intanciar um objeto da classe desejada 
    Classe1 classe1;

    void metodo() {
        System.out.println(classe1.atributo2);
        System.out.println(classe1.atributo3);

        classe1.metodo2();
        classe1.metodo3();
    }
}
