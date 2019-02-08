package br.edu.ifnmg.poo2.filters;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.edu.ifnmg.poo2.bean.SecretaryBean;
import br.edu.ifnmg.poo2.entity.Secretary;

@Named
@SessionScoped
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;

	private Secretary secretary;
	
	private String loginTest;
	
	private String senhaTest;
	
	@Inject
	private SecretaryBean service;

	public Secretary getSecretary() {
		return secretary;
	}

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public String getLoginTest() {
		return loginTest;
	}

	public void setLoginTest(String loginTest) {
		this.loginTest = loginTest;
	}

	public String getSenhaTest() {
		return senhaTest;
	}

	public void setSenhaTest(String senhaTest) {
		this.senhaTest = senhaTest;
	}

	public SecretaryBean getService() {
		return service;
	}

	public void setService(SecretaryBean service) {
		this.service = service;
	}
	
	public String loginSystem() {
		if(service.permissao(loginTest, senhaTest)){
			//Add user session
			//System.out.println("Entrou");
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			secretary = new Secretary();
			session.setAttribute("usuario", secretary);
			return "/view/index.xhtml?faces-redirect=true";
		}
		else{
			return "/login.xhtml?faces-redirect=true";
		}
	}
	
	public String logoutSystem() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
}
