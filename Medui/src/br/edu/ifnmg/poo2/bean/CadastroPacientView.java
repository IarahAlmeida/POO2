package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Address;
import br.edu.ifnmg.poo2.entity.ContactNumber;
import br.edu.ifnmg.poo2.entity.Patient;
import br.edu.ifnmg.poo2.entity.Responsible;
import br.edu.ifnmg.poo2.service.ResponsibleService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class CadastroPacientView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	private ContactNumber contacNumber;
	private Address address;
	private List<Responsible> respCadastrados;
	private List<Responsible> respAtribuidos;
	private List<Responsible> respCadastradosFiltrados;
	private List<Responsible> respAtribuidosFiltrados;
	private Responsible selectedRespUp;
	private Responsible selectedRespDw;
	private Responsible novoResp;
	
	@Inject
	private ResponsibleService respService;
	
	@PostConstruct
	public void init() {
		patient = new Patient();
		contacNumber = new ContactNumber();
		address = new Address();
		
		try {
			respCadastrados = respService.getResponsibles();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		respAtribuidos = new ArrayList<>();
	}
	
	public void prepararNovoResponsavel() {
		novoResp = new Responsible();
	}
	
	public void salvarResponsavel() {
		
		try {
			respService.salvar(novoResp);
			respCadastrados = respService.getResponsibles();
			JSFUtil.adicionarMensagemSucesso("Responsável Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}	 
	}
	
	public void atribuirtResponsavel() {
		respAtribuidos.add(selectedRespUp);
	}
	
	public void removerResponsavelAtribuido () {
		respAtribuidos.remove(selectedRespDw);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public ContactNumber getContacNumber() {
		return contacNumber;
	}

	public void setContacNumber(ContactNumber contacNumber) {
		this.contacNumber = contacNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Responsible> getRespCadastrados() {
		return respCadastrados;
	}

	public void setRespCadastrados(List<Responsible> respCadastrados) {
		this.respCadastrados = respCadastrados;
	}

	public List<Responsible> getRespAtribuidos() {
		return respAtribuidos;
	}

	public void setRespAtribuidos(List<Responsible> respAtribuidos) {
		this.respAtribuidos = respAtribuidos;
	}
	

	public List<Responsible> getRespCadastradosFiltrados() {
		return respCadastradosFiltrados;
	}

	public void setRespCadastradosFiltrados(List<Responsible> respCadastradosFiltrados) {
		this.respCadastradosFiltrados = respCadastradosFiltrados;
	}

	public List<Responsible> getRespAtribuidosFiltrados() {
		return respAtribuidosFiltrados;
	}

	public void setRespAtribuidosFiltrados(List<Responsible> respAtribuidosFiltrados) {
		this.respAtribuidosFiltrados = respAtribuidosFiltrados;
	}

	public Responsible getSelectedRespUp() {
		return selectedRespUp;
	}

	public void setSelectedRespUp(Responsible selectedRespUp) {
		this.selectedRespUp = selectedRespUp;
	}

	public Responsible getSelectedRespDw() {
		return selectedRespDw;
	}

	public void setSelectedRespDw(Responsible selectedRespDw) {
		this.selectedRespDw = selectedRespDw;
	}

	public Responsible getNovoResp() {
		return novoResp;
	}

	public void setNovoResp(Responsible novoResp) {
		this.novoResp = novoResp;
	}

	public ResponsibleService getRespService() {
		return respService;
	}

	public void setRespService(ResponsibleService respService) {
		this.respService = respService;
	}

}
