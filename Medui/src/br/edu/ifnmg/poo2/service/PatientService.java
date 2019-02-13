package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import br.edu.ifnmg.poo2.entity.Patient;

@Named
@SessionScoped
public class PatientService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Patient patient) {
		entityManager.persist(entityManager.contains(patient) ? patient : entityManager.merge(patient));
	}
	
	@Transactional
	public void excluir(Patient patient) {
		entityManager.remove(entityManager.contains(patient) ? patient : entityManager.merge(patient));
	}
	
	@Transactional
	public Patient buscar(Long id) {
		return entityManager.find(Patient.class, id);
	}
	
	@Transactional
	public List<Patient> getPatients() {
		TypedQuery<Patient> query = entityManager.createNamedQuery("allPatients", Patient.class);
		return query.getResultList();
	}
}
