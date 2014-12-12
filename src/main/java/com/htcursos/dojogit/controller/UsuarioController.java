package com.htcursos.dojogit.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.htcursos.dojogit.service.UsuarioService;

@Controller
@javax.faces.view.ViewScoped
public class UsuarioController {
	
	private static final String LISTA_USUARIO = "/pages/usuario/lista";

	private static final String CADASTRO_USUARIO = "/cadastro";

	private static final String REDIRECT_PAGE = "?faces-redirect=true";

	private Usuario usuario;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private List<Usuario> usuarios;
	

	
	@PostConstruct
	protected void init(){
		buscar();
		novo();
	}
	
	public String editar(Long id){
		usuario = usuarioService.findById(id);
		return CADASTRO_USUARIO + REDIRECT_PAGE;
	}
	
	public String novo(){
		usuario = new Usuario();
		return CADASTRO_USUARIO + REDIRECT_PAGE;
	}
	
	public String cancelar(){
		return LISTA_USUARIO + REDIRECT_PAGE;
	}
	
	public void buscar(){
		usuarios = usuarioService.findAll();
	}
	
	public void remover(Usuario usuario){
		usuarios.remove(usuario);
		usuarioService.remove(usuario.getId());
		MensagemUtil.info("UsuÃ¡rio removido com sucesso");
	}
	
	public void salvar(){
		try{
		usuarioService.save(usuario);
		
		int indice = usuarios.indexOf(usuario);
		if(indice >= 0){
			usuarios.set(indice, usuario);
		}else{
			usuarios.add(usuario);
		}
		novo();
		MensagemUtil.info("Usuário salvo com sucesso");
		}catch(ServiceException e){
			MensagemUtil.aviso(e.getMessage());
		}
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Perfil> getPerfis() {
		return perfis;
	}
}


