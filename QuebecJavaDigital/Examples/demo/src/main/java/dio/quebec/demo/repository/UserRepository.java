package dio.quebec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.quebec.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
/*     public void deleteDados() {
        System.out.println("Apagando dados");
    } */
}
