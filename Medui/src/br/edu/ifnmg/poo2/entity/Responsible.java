package br.edu.ifnmg.poo2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	
})
public class Responsible extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "responsibles", cascade = CascadeType.ALL)
	private List<Patient> patients = new ArrayList<>();

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}
