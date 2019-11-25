package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.model.Usuario;

@Controller
public class UsuarioSistemaController {
	
	public void form() {
		
	}
	
	@Post
	public void salvaForm(Usuario usuario) {
		System.out.println("######################## Executei"+usuario.getEmail());
	}
}
