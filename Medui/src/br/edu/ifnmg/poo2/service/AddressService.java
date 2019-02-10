package br.edu.ifnmg.poo2.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.poo2.entity.Address;

@Stateful
public class AddressService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	public List<Address> getAddresses() {
		TypedQuery<Address> query = entityManager.createNamedQuery("allAddress", Address.class);
		return query.getResultList();
	}
}
