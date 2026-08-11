package mx.app.alta.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersAdd {
    @NotNull(message = "El nombre no puede ir nulo")
    @NotBlank(message = "El nombre no puede ir vacio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(
            regexp = "^[\\p{L}\\s'-]+$",
            message = "El nombre solo debe contener letras, espacios, apóstrofes o guiones"
    )
    private String name;
    @NotNull(message = "Usuario no puede ir nulo")
    @NotBlank(message = "Usuario no puede ir vacio")
    private String user;
    @NotNull(message = "Password no puede ir nulo")
    @NotBlank(message = "Password no puede ir vacio")
    private String password;
    @NotNull(message = "Password no puede ir nulo")
    @NotBlank(message = "Password no puede ir vacio")
    private String repeatPass;
    private byte[] photo;
    private Boolean active;
    private Long idPerfil;

}
