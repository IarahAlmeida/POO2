package br.edu.ifnmg.poo2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	
})
public class Secretary extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 20, nullable = false, unique = true)
	private String login;
	
	@Column(length = 50, nullable = false)
	private String password_hash;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
