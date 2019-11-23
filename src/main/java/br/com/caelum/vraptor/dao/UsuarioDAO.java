package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Usuario;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario, Long> {
	
	@Inject
	public UsuarioDAO(EntityManager em) {
		super(em, Usuario.class);
	}
	
	@Deprecated public UsuarioDAO() {this(null);}// uso do CDI

}
