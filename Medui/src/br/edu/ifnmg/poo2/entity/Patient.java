package br.edu.ifnmg.poo2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "allPatients", // 
			query = "select p from Patient p")
})
public class Patient extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthdate;
	
	@Column(length = 10)
	private String sex;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinTable(
			joinColumns = @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_patient")),
			inverseJoinColumns = @JoinColumn(name = "responsible_id", foreignKey = @ForeignKey(name = "fk_responsible"))
	)
	private List<Responsible> responsibles = new ArrayList<>();
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<>();

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Responsible> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(List<Responsible> responsibles) {
		this.responsibles = responsibles;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
