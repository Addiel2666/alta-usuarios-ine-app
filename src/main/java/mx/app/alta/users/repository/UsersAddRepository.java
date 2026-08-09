package mx.app.alta.users.repository;

import mx.app.alta.users.model.UsersAdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersAddRepository extends JpaRepository<UsersAdd,Long> {
}
