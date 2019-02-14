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
import br.edu.ifnmg.poo2.entity.Doctor;
import br.edu.ifnmg.poo2.service.DoctorService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class CadastroMedicoView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Doctor doctor;
	private ContactNumber contactNumber;
	private Address address;
	private String selectedSpecialty;
    private List<String> specialtys;
    
    @Inject
    private DoctorService docService;
    
    @PostConstruct
    public void init() {
    	doctor = new Doctor();
    	contactNumber = new ContactNumber();
    	address = new Address();
    	specialtys = new ArrayList<String>();
    	specialtys.add("cardiologista");
    	specialtys.add("dermatologista");
    	specialtys.add("neurologista");
    	specialtys.add("nutricionista");
    	specialtys.add("ortopedista");
    	specialtys.add("cirurgião");
    }

    public void cadastrarMedico() {
		if(selectedSpecialty == null ) {
			JSFUtil.adicionarMensagemErro("Selecione uma especialização");
		}
		else {
	    	address.setCountry("Brasil");
	    	doctor.setAddress(address);
			doctor.setContactNumber(contactNumber);
			doctor.setSpecialty(selectedSpecialty);
			try {
				docService.salvar(doctor);
				JSFUtil.adicionarMensagemSucesso("Médico cadastrado!");
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

	public ContactNumber getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
