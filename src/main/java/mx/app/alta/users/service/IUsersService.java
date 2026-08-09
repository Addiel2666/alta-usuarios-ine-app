package mx.app.alta.users.service;

import mx.app.alta.users.dto.UsersAdd;
import mx.app.alta.users.dto.ResponseUser;

public interface IUsersService {

    ResponseUser altaUser(UsersAdd request);

}
