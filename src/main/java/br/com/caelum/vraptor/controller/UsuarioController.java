package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject UsuarioDAO usuarioDAO;
	@Inject Result result;

	public void form() {
		
	}
	
	@Post
	public void salvaForm(Usuario usuario) {
		usuarioDAO.insert(usuario);
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		List<Usuario> usuarios = usuarioDAO.selectAll();
		result.include("usuariosList", usuarios);
	}
}
