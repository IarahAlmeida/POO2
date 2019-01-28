package br.edu.ifnmg.poo2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	
})
public class Secretary extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Column(length = 15, nullable = false, unique = true)
	private String rg;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
}
