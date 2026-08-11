package mx.app.alta.users.controller;

import jakarta.validation.Valid;
import mx.app.alta.users.dto.UsersAdd;
import mx.app.alta.users.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsersController {

    @Autowired
    IUsersService iUsersService;

    @PostMapping("/guarda")
    public ResponseEntity<?> guardaUsuario(@Valid @RequestBody UsersAdd request) {
        return ResponseEntity.ok(iUsersService.altaUser(request));
    }

    @GetMapping("/consultaTodos")
    public ResponseEntity<?> consultaUsuarios(){
        return ResponseEntity.ok(iUsersService.usuariosPerfil());
    }

    @GetMapping("/perfiles")
    public ResponseEntity<?> perfiles(){
        return ResponseEntity.ok(iUsersService.perfiles());
    }
}
