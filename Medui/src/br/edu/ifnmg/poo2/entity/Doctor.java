package br.edu.ifnmg.poo2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "allDoctors", // 
			query = "select d from Doctor d")
})
public class Doctor extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 30, nullable = false)
	private String crm_state;
	
	@Column(length = 30, nullable = false, unique = true)
	private String crm_number;
	
	@Column(length = 50, nullable = false)
	private String specialty;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<>();

	public String getCrm_state() {
		return crm_state;
	}

	public void setCrm_state(String crm_state) {
		this.crm_state = crm_state;
	}

	public String getCrm_number() {
		return crm_number;
	}

	public void setCrm_number(String crm_number) {
		this.crm_number = crm_number;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
