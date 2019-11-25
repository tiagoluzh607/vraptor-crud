package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.exception.RegistroInativoException;
import br.com.caelum.vraptor.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject UsuarioDAO usuarioDAO;
	@Inject Result result;

	public void form(Usuario usuario) throws RegistroInativoException {
		if(usuario != null && usuario.getId() > 0) { //caso seja passado um usuario pesquisa ele no banco e disponibiza ele na tela
			Usuario usuarioDoBanco = usuarioDAO.selectPorId(usuario);
			result.include("usuario", usuario);
		}
	}
	
	@Post
	public void salvaForm(Usuario usuario) {
		
		if(usuario .getId() > 0) { //caso o usuario jah tenha ID atualiza
			usuarioDAO.update(usuario);
		}else {
			usuarioDAO.insert(usuario);
		}
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		List<Usuario> usuarios = usuarioDAO.selectAll();
		result.include("usuariosList", usuarios);
	}
	
	public void deletaUsuario(Usuario usuario) {
		if(usuario.getId() > 0) {
			usuarioDAO.delete(usuario);
		}
		result.redirectTo(this).lista();
	}
}
