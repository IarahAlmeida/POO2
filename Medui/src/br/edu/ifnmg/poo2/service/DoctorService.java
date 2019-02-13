package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.edu.ifnmg.poo2.entity.Doctor;

@Named
@SessionScoped
public class DoctorService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	@Transactional
	public List<Doctor> getDoctors() {
		TypedQuery<Doctor> query = entityManager.createNamedQuery("allDoctors", Doctor.class);
		return query.getResultList();
	}
}