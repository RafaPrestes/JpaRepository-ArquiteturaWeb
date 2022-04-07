package com.example.aula03;

import java.util.List;

import com.example.aula03.entity.Perfil;
import com.example.aula03.entity.Usuario;
import com.example.aula03.repository.PerfilRepository;
import com.example.aula03.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula03Application {
	@Bean
	public CommandLineRunner init(@Autowired UsuarioRepository usuarioRepository,
	 @Autowired PerfilRepository perfilRepository){
		return args ->{
			Perfil pAdmin = new Perfil(0,"Admin");
			Perfil pBasico = new Perfil(0, "Basico");
			perfilRepository.save(pAdmin);
			perfilRepository.save(pBasico);

			Usuario usul = new Usuario (0, "teste", "teste@teste", "123");
			usul.setPerfil(pAdmin);
			usuarioRepository.save(usul);

			Usuario usu2 = new Usuario(0, "rafael", "rafael@rafael", "321");
			usu2.setPerfil(pBasico);
			usuarioRepository.save(usu2); //save é o metodo do proprio JpaRepository

			List<Usuario> listaUsuarios = usuarioRepository.findAll(); //Buscando todos usuarios
			listaUsuarios.forEach(System.out::println);

			System.out.println("*** PESQUISAR POR NOME ***");
			System.out.println(usuarioRepository.findByNomeLike("ra%")); //Buscando usuario por nome q começe com ra

			System.out.println("*** PERFIL FETCH USUARIO ***");
			System.out.println(perfilRepository.findPerfilByIdFetchUsuarios(1));

	};	
}

	public static void main(String[] args) {
		SpringApplication.run(Aula03Application.class, args);
	}

}
