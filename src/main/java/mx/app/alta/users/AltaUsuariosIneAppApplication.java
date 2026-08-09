package mx.app.alta.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "mx.app.alta.users.repository")
public class AltaUsuariosIneAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltaUsuariosIneAppApplication.class, args);
	}

}
