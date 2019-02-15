package br.edu.ifnmg.poo2.lista;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Named
@SessionScoped
public class QuestaoListaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	@Transactional
	public Country getContry(String name) {
		TypedQuery<Country> query = entityManager.createNamedQuery("findByName", Country.class);
		query.setParameter("name",
				name);
		return query.getSingleResult();
	}
}
