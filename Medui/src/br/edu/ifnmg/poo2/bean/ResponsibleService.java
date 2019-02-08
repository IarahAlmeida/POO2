package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.poo2.entity.Responsible;

@Named
@SessionScoped
public class ResponsibleService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	public List<Responsible> getResponsibles() {
		TypedQuery<Responsible> query = entityManager.createNamedQuery("allResponsible", Responsible.class);
		return query.getResultList();
	}
}
