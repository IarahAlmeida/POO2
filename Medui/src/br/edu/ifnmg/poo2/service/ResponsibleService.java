package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import br.edu.ifnmg.poo2.entity.Responsible;

@Named
@SessionScoped
public class ResponsibleService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Responsible responsible) {
		entityManager.persist(entityManager.contains(responsible) ? responsible : entityManager.merge(responsible));
	}
	
	@Transactional
	public void excluir(Responsible responsible) {
		entityManager.remove(entityManager.contains(responsible) ? responsible : entityManager.merge(responsible));
	}
	
	@Transactional
	public Responsible buscar(Long id) {
		return entityManager.find(Responsible.class, id);
	}
	
	@Transactional
	public List<Responsible> getResponsibles() {
		TypedQuery<Responsible> query = entityManager.createNamedQuery("allResponsible", Responsible.class);
		return query.getResultList();
	}
}
