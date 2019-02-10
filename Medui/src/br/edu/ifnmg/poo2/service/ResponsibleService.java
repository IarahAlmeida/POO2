package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.poo2.entity.Responsible;

@Stateful
public class ResponsibleService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	public void salvar(Responsible responsible) {
		entityManager.persist(entityManager.contains(responsible) ? responsible : entityManager.merge(responsible));
	}
	
	public List<Responsible> getResponsibles() {
		TypedQuery<Responsible> query = entityManager.createNamedQuery("allResponsible", Responsible.class);
		return query.getResultList();
	}
}
