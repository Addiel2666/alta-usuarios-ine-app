package mx.app.alta.users.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cat_perfil")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfil", nullable = false)
    private String perfil;

}
