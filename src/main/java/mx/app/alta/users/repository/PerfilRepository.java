package mx.app.alta.users.repository;

import mx.app.alta.users.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
