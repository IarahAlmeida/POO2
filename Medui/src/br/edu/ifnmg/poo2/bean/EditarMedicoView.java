package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.ArrayList;
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
public class EditarMedicoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Doctor doctor;
	private Long codigo;
	private String selectedSpecialty;
    private List<String> specialtys;
    
    @Inject
    private DoctorService docService;
    
    @PostConstruct
	public void init() {
    	specialtys = new ArrayList<String>();
    	specialtys.add("cardiologista");
    	specialtys.add("dermatologista");
    	specialtys.add("neurologista");
    	specialtys.add("nutricionista");
    	specialtys.add("ortopedista");
    	specialtys.add("cirurgião");
	}
    
    public void carregarEdicao() {
		try {
			doctor = docService.buscar(codigo);
			selectedSpecialty = doctor.getSpecialty();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
    
    public void editarMedico() {
		if(selectedSpecialty == null ) {
			JSFUtil.adicionarMensagemErro("Selecione uma especialização");
		}
		else {
			doctor.setSpecialty(selectedSpecialty);
			try {
				docService.salvar(doctor);
				JSFUtil.adicionarMensagemSucesso("Médico Atualizado!");
			} catch (Exception e) {
				e.printStackTrace();
				JSFUtil.adicionarMensagemErro(e.getMessage());
			}
		}
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSelectedSpecialty() {
		return selectedSpecialty;
	}

	public void setSelectedSpecialty(String selectedSpecialty) {
		this.selectedSpecialty = selectedSpecialty;
	}

	public List<String> getSpecialtys() {
		return specialtys;
	}

	public void setSpecialtys(List<String> specialtys) {
		this.specialtys = specialtys;
	}

	public DoctorService getDocService() {
		return docService;
	}

	public void setDocService(DoctorService docService) {
		this.docService = docService;
	}
}
