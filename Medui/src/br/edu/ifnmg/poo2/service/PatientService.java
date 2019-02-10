package br.edu.ifnmg.poo2.service;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.poo2.entity.Patient;

@Stateful
public class PatientService implements Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	public void salvar(Patient patient) {
		entityManager.persist(entityManager.contains(patient) ? patient : entityManager.merge(patient));
	}
}
