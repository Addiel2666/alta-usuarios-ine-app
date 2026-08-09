package mx.app.alta.users.service.impl;

import lombok.extern.log4j.Log4j2;
import mx.app.alta.users.dto.Constantes;
import mx.app.alta.users.dto.UsersAdd;
import mx.app.alta.users.dto.ResponseUser;
import mx.app.alta.users.repository.UsersAddRepository;
import mx.app.alta.users.service.IUsersService;
import mx.app.alta.users.util.EncriptyngPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UsersServiceImpl implements IUsersService {

    @Autowired
    UsersAddRepository addRepository;

    @Autowired
    EncriptyngPass encriptyngPass;

    @Override
    public ResponseUser altaUser(UsersAdd request) {
        ResponseUser responseUser = new ResponseUser();
        try{
            if(!request.getPassword().equals(request.getRepeatPass())){
                return new ResponseUser(Constantes.CODE_ERROR_NAME,Constantes.MSG_ERROR_PASSWORD);
            }else{
                String passEncript = encriptyngPass.encode(request.getPassword());
                request.setPassword(passEncript);
            }
            mx.app.alta.users.model.UsersAdd usersAdd = new mx.app.alta.users.model.UsersAdd(request.getName(),request.getUser(), request.getPassword(), request.getPhoto(), true);
            addRepository.save(usersAdd);
            responseUser.setCode(Constantes.CODE_200_ALTA);
            responseUser.setMessage(Constantes.MSG_200_ALTA);
        }catch (Exception e){
            log.info("Este fue el error ",e.getMessage());
        }

        return responseUser;
    }
}
