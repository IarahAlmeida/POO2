package br.edu.ifnmg.poo2.bean;

import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Doctor;
import br.edu.ifnmg.poo2.service.DoctorService;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Named
@ViewScoped
public class CarouselView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Doctor> docs;
    
    private Doctor selectedDoc;
     
    @Inject
    private DoctorService service;
     
    @PostConstruct
    public void init() {
        docs = service.getDoctors();
    }
 
    public List<Doctor> getDocs() {
        return docs;
    }
 
    public void setService(DoctorService service) {
        this.service = service;
    }
 
    public Doctor getSelectedDoctor() {
        return selectedDoc;
    }
 
    public void setSelectedDoctor(Doctor selectedDoc) {
        this.selectedDoc = selectedDoc;
    }
}
