package mx.app.alta.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "users_add")
@AllArgsConstructor
@NoArgsConstructor
public class UsersAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String user;
    private String password;
    private byte[] photo;
    private Boolean active;

    public UsersAdd(String name, String user, String password, byte[] photo, Boolean active) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.photo = photo;
        this.active = active;
    }
}
