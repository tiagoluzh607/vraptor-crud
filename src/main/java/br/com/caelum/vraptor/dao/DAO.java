package br.com.caelum.vraptor.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.caelum.vraptor.exception.IdInvalidoException;
import br.com.caelum.vraptor.exception.RegistroInativoException;
import br.com.caelum.vraptor.model.Model;

public abstract class DAO<T extends Model, I extends Serializable> {
	
	protected EntityManager em;
	private Class<T> persistedClass;
	
	public DAO(EntityManager em, Class<T> persistedClass) {
		this.em = em;
		this.persistedClass = persistedClass;
	}
	
	/**
	 * Persiste um Objeto passado como parâmetro no banco de dados
	 * @param object
	 */
	public T insert(T model) {
		em.persist(model);
		return model;
	}

	/**0
	 * Persiste ou atualiza um objeto passado como parâmetro no banco de dados
	 * @param object
	 */
	public T insertOrUpdate(T model) { 
		
		if(model.getId() < 1) {
			return insert(model);
		}
		
		return update(model);
		
	}
	
	/**
	 * atualiza um objeto passado como parâmetro no banco de dados
	 * @param object
	 */
	public T update(T model) { 
		
		model = em.merge(model);
		em.persist(model);
		return model;
	}
	
	/**
	 * Deleta um Objeto passado como parâmetro no banco de dados
	 * OBS: Este Objeto deve ter o ID informado
	 * @param object
	 */
	public void delete(T model) {
		if(model!= null && model.getId() < 1) {
			throw new IdInvalidoException("Não foi Possível deletar pois o id é 0 ou inválido!  classe do registro:"+ model.getClass().getSimpleName() + " id do registro: "+model.getId());
		}
		model = em.merge(model);
		em.remove(model);
	}
	
	/**
	 * Traz um Registro Ativo pesquisando por id no banco de dados
	 * caso queira pegar registros tanto ativos como inativos usar função
	 * SelectPorIdMesmoInativo
	 * @param model
	 * @return
	 * @throws RegistroInativoException 
	 */
	public T selectPorId(T model) throws RegistroInativoException {
		
		model = em.find(this.persistedClass, model.getId());
		
		//Verifica se o Registro esta inativo no banco de dados caso inativo estoura uma exception
		if(model != null) {
			if(!model.isAtivo()) {
				throw new RegistroInativoException(
						"O Registro que tentou buscar, esta inativo no Banco de Dados! classe do registro:" + model.getClass().getSimpleName() + 
						" id do registro: "+model.getId());
			}
		}	
		return model; //Sera retornado o registro encontrado, ou nulo, ou se tiver inativo estoura a exeption
		
		
	}
	
	/**
	 * busca um registro do banco de dados por id ele pode estar ativo ou inativo
	 * @param model
	 * @return
	 * @throws RegistroInativoException
	 */
	public T selectPorIdComInativo(T model){
		return em.find(  this.persistedClass, model.getId());
	}
	
	public List<T> selectAll(){
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
	    CriteriaQuery<T> query = builder.createQuery(persistedClass);
	    Root<T> root = query.from(persistedClass);
	       
	    List<Predicate> predicates = new ArrayList<Predicate>();
	    
	    //Criando Filtros Para somente Ativos
  		Path<Boolean> pathAtivo = root.<Boolean> get("ativo");
		Predicate estaAtivo = builder.equal(pathAtivo, true);
		predicates.add(estaAtivo);
	  		
	  	//Adicionando os predicatos para gerar Where Automaticamente
	  	query.where((Predicate[]) predicates.toArray(new Predicate[0]));    
	    return this.em.createQuery(query).getResultList();
	}
	
	public List<T> selectAllComInativos(){
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
	    CriteriaQuery<T> query = builder.createQuery(persistedClass);
	    query.from(persistedClass);
	    return this.em.createQuery(query).getResultList();
	}
	
	

}
