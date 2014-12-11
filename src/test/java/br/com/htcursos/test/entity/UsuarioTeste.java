package br.com.htcursos.test.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.htcursos.entity.Usuario;
import com.htcursos.service.UsuarioService;

@ContextConfiguration(locations="/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioTeste {
	
	@Autowired
	private static UsuarioService usuarioService;
     
	
	
	public static void main (){
		Usuario usuario = new Usuario();
		usuario.setNome("ZEDASILVA");
		usuario.setEmail("user11@server.com");
		usuario.setFoto("Foto1.jpg");

		usuarioService.save(usuario);
		System.out.println(usuarioService.findAll());
	}

}
