package com.htcursos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.htcursos.entidade.Usuario;

@Controller

public class UsuarioController {

	private Usuario usuario;
	
	private List<Usuario> usuarios;
	
	//Metodo Novo Usuario
	public void novo(){
		usuario = new Usuario();
	}
	
	//Metodo Buscar Usuarios
	public void buscar(){
		usuarios = usuarioService.findAll;
	}
		
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	
}
