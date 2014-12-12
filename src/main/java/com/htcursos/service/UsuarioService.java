/**
 * 
 */
package com.htcursos.service;

import org.springframework.stereotype.Service;

import com.htcursos.entity.Usuario;

/**
 * @author ramon
 *
 */
@Service
public class UsuarioService extends GenericService<Usuario, Long> {

	public UsuarioService() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

}
