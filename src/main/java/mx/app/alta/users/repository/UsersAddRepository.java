package mx.app.alta.users.repository;

import mx.app.alta.users.model.Perfil;
import mx.app.alta.users.model.UsersAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersAddRepository extends JpaRepository<UsersAdd,Long> {

    @Query(value = "SELECT * FROM users_add u WHERE u.active =:active")
    List<UsersAdd> consultaUsuarios(@Param("active") int active);

}
