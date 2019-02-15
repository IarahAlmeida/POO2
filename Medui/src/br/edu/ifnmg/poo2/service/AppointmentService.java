package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import br.edu.ifnmg.poo2.entity.Appointment;

@Named
@SessionScoped
public class AppointmentService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Appointment consulta) {
		entityManager.persist(entityManager.contains(consulta) ? consulta : entityManager.merge(consulta));
	}
	
	@Transactional
	public void excluir(Appointment consulta) {
		entityManager.remove(entityManager.contains(consulta) ? consulta : entityManager.merge(consulta));
	}
	
	@Transactional
	public Appointment buscar(Long id) {
		return entityManager.find(Appointment.class, id);
	}
	
	@Transactional
	public List<Appointment> getConsultas() {
		TypedQuery<Appointment> query = entityManager.createNamedQuery("allConsultas", Appointment.class);
		return query.getResultList();
	}
}
