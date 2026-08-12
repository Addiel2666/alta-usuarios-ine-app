package mx.app.alta.users.service.impl;

import lombok.extern.log4j.Log4j2;
import mx.app.alta.users.dto.Constantes;
import mx.app.alta.users.dto.UsersAdd;
import mx.app.alta.users.dto.ResponseUser;
import mx.app.alta.users.dto.UsersConsulta;
import mx.app.alta.users.model.Perfil;
import mx.app.alta.users.repository.PerfilRepository;
import mx.app.alta.users.repository.UsersAddRepository;
import mx.app.alta.users.service.IUsersService;
import mx.app.alta.users.util.EncriptyngPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UsersServiceImpl implements IUsersService {

    @Autowired
    UsersAddRepository addRepository;

    @Autowired
    EncriptyngPass encriptyngPass;

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public ResponseUser altaUser(UsersAdd request) {
        ResponseUser responseUser = new ResponseUser();
        try{
            if(!request.getPassword().equals(request.getRepeatPass())){
                return new ResponseUser(Constantes.CODE_ERROR_NAME,Constantes.MSG_ERROR_PASSWORD);
            }else{
                String passEncript = encriptyngPass.encode(request.getPassword());
                request.setPassword(passEncript);
                request.setActive(true);
            }
            Optional<Perfil> perfil = perfilRepository.findById(request.getIdPerfil());
            mx.app.alta.users.model.UsersAdd usersAdd = new mx.app.alta.users.model.UsersAdd(request.getName(),request.getUser(), request.getPassword(), request.getPhoto(), true,perfil.get());
            addRepository.save(usersAdd);
            responseUser.setCode(Constantes.CODE_200_ALTA);
            responseUser.setMessage(Constantes.MSG_200_ALTA);
        }catch (Exception e){
            log.info("Este fue el error ",e.getMessage());
        }

        return responseUser;
    }

    @Override
    public List<Perfil> perfiles() {
        return perfilRepository.findAll();
    }

    @Override
    public List<UsersConsulta> usuariosPerfil() {
        try {
            List<mx.app.alta.users.model.UsersAdd> perfil = addRepository.consultaUsuarios(new Long(1));
            List<UsersConsulta> listaUsuarios = new ArrayList<>();
            perfil.forEach(usersAdd -> {
                UsersConsulta usersConsulta = new UsersConsulta(usersAdd.getName(), usersAdd.getUser(), usersAdd.getPhoto(), usersAdd.getActive(), usersAdd.getPerfil().getPerfil());
                listaUsuarios.add(usersConsulta);
            });
            return listaUsuarios;
        }catch (Exception e){
            log.info("Este fue el error ",e.getMessage());
        }
        return null;
    }
}
