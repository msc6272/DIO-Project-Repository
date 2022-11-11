package dio.quebec.SpringDataJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.quebec.SpringDataJpa.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
    //Query Method
    List<Users> findByNameContaining(String name);
    
    //Query Method
    Users findByUsername(String username);

    //Query Override
    @Query("SELECT u FROM Users u WHERE u.name LIKE %:name%")
    List<Users> filtrarPorNome(@Param("name") String name);
}
