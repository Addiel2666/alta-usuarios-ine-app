package mx.app.alta.users.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersConsulta {

    private String nombre;
    private String user;
    private byte[] photo;
    private Boolean active;
    private String perfil;

}
