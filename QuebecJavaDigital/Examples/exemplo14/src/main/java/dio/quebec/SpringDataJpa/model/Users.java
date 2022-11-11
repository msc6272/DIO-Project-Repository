package dio.quebec.SpringDataJpa.model;

import javax.persistence.*;

@Entity
// A classe não pode se chamar User, pois dá conflito com o H2 Database 
// Ao inves de ter renomeado a classe, de User para Users, poderia ter adicionado a anotação abaixo
// @Table(name = "tab_user") 
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;
    
    @Override
    public String toString() {
        return "User {id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
