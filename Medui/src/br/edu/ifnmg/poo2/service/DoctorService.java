package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.poo2.entity.Doctor;

@Stateful
public class DoctorService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	public List<Doctor> getDoctors() {
		TypedQuery<Doctor> query = entityManager.createNamedQuery("allDoctors", Doctor.class);
		return query.getResultList();
	}
}