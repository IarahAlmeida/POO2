package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Appointment;
import br.edu.ifnmg.poo2.entity.Doctor;
import br.edu.ifnmg.poo2.entity.Patient;
import br.edu.ifnmg.poo2.service.AppointmentService;
import br.edu.ifnmg.poo2.service.DoctorService;
import br.edu.ifnmg.poo2.service.PatientService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class CadastroConsultaView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Appointment consulta;
	private Patient selectedPatient;
	private Doctor selectedDoctor;
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Patient> patientsFiltrados;
	private List<Doctor> doctorsFiltrados;
	private Date dataConsulta;
	
	@Inject
	private AppointmentService consultService;
	
	@Inject
	private PatientService patService;
	
	@Inject
	private DoctorService docService;
	
	@PostConstruct
	public void init() {
		consulta = new Appointment();
		patients = patService.getPatients();
		doctors = docService.getDoctors();
	}
	
	public void marcarConsulta() {
		try {
			if(selectedPatient == null) {
				JSFUtil.adicionarMensagemErro("Paciente não selecionado");
			}
			else if(selectedDoctor == null){
				JSFUtil.adicionarMensagemErro("Médico não selecionado");			
			}
			else {
				consulta.setDate_time(dataConsulta);
				consulta.setPatient(selectedPatient);
				consulta.setDoctor(selectedDoctor);
				consultService.salvar(consulta);
				JSFUtil.adicionarMensagemSucesso("Consulta Agendada");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public Appointment getConsulta() {
		return consulta;
	}

	public void setConsulta(Appointment consulta) {
		this.consulta = consulta;
	}

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(Doctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Patient> getPatientsFiltrados() {
		return patientsFiltrados;
	}

	public void setPatientsFiltrados(List<Patient> patientsFiltrados) {
		this.patientsFiltrados = patientsFiltrados;
	}

	public List<Doctor> getDoctorsFiltrados() {
		return doctorsFiltrados;
	}

	public void setDoctorsFiltrados(List<Doctor> doctorsFiltrados) {
		this.doctorsFiltrados = doctorsFiltrados;
	}

	public AppointmentService getConsultService() {
		return consultService;
	}

	public void setConsultService(AppointmentService consultService) {
		this.consultService = consultService;
	}

	public PatientService getPatService() {
		return patService;
	}

	public void setPatService(PatientService patService) {
		this.patService = patService;
	}

	public DoctorService getDocService() {
		return docService;
	}

	public void setDocService(DoctorService docService) {
		this.docService = docService;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
}
