package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Patient;
import br.edu.ifnmg.poo2.entity.Responsible;
import br.edu.ifnmg.poo2.service.ResponsibleService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class EditarResponsavelView implements Serializable{

	private static final long serialVersionUID = 1L;

	private Responsible responsible;
	private Long codigo;
	private List<Patient> patients;
	private List<Patient> patientsFiltrados;
	
	@Inject
	private ResponsibleService respService;
	
	@PostConstruct
	public void init() {
		patients = new ArrayList<>();
	}
	
	public void carregarEdicao() {
		try {
			responsible = respService.buscar(codigo);
			patients = responsible.getPatients();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editarResponsible() {
		try {
			respService.salvar(responsible);
			JSFUtil.adicionarMensagemSucesso("Responsável Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Patient> getPatientsFiltrados() {
		return patientsFiltrados;
	}

	public void setPatientsFiltrados(List<Patient> patientsFiltrados) {
		this.patientsFiltrados = patientsFiltrados;
	}

	public ResponsibleService getRespService() {
		return respService;
	}

	public void setRespService(ResponsibleService respService) {
		this.respService = respService;
	}
}
