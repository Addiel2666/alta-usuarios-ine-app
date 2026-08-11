package mx.app.alta.users.service;

import mx.app.alta.users.dto.UsersAdd;
import mx.app.alta.users.dto.ResponseUser;
import mx.app.alta.users.dto.UsersConsulta;
import mx.app.alta.users.model.Perfil;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface IUsersService {

    ResponseUser altaUser(UsersAdd request);
    List<Perfil> perfiles();
    List<UsersConsulta> usuariosPerfil();
}
