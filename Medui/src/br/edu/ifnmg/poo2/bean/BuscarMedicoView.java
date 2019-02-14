package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Doctor;
import br.edu.ifnmg.poo2.service.DoctorService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class BuscarMedicoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Doctor> doctors;
	private List<Doctor> doctorsFiltrados;
	private Doctor selectedDoctor;
	
	@Inject
	private DoctorService docService;
	
	@PostConstruct
	public void init() {
		try {
			doctors = docService.getDoctors();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluirMedico() {
		try {
			docService.excluir(selectedDoctor);
			doctors = docService.getDoctors();
			JSFUtil.adicionarMensagemSucesso("Médico Excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Doctor> getDoctorsFiltrados() {
		return doctorsFiltrados;
	}

	public void setDoctorsFiltrados(List<Doctor> doctorsFiltrados) {
		this.doctorsFiltrados = doctorsFiltrados;
	}

	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(Doctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	public DoctorService getDocService() {
		return docService;
	}

	public void setDocService(DoctorService docService) {
		this.docService = docService;
	}
}
