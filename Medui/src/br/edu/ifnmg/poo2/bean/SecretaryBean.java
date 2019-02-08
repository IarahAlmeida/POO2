package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@SessionScoped
public class SecretaryBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Medui")
	private EntityManager entityManager;
	
	
	//Verificação de senha e usuario
	public Boolean permissao(String loginTest, String senhaTest) {
		return true;
	}
}
