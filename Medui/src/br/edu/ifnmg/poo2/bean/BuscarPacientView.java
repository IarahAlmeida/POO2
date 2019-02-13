package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Patient;
import br.edu.ifnmg.poo2.service.PatientService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class BuscarPacientView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Patient> patients;
	private List<Patient> patientsFiltrados;
	private Patient selectedPatient;
	
	@Inject
	private PatientService patService;
	
	@PostConstruct
	public void init() {
		try {
			patients = patService.getPatients();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluirPatient () {
		try {
			patService.excluir(selectedPatient);
			patients = patService.getPatients();
			JSFUtil.adicionarMensagemSucesso("Paciente Excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
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
	
	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public PatientService getPatService() {
		return patService;
	}

	public void setPatService(PatientService patService) {
		this.patService = patService;
	}
}
