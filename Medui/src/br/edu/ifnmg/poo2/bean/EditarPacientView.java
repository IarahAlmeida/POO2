package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Patient;
import br.edu.ifnmg.poo2.entity.Responsible;
import br.edu.ifnmg.poo2.service.PatientService;
import br.edu.ifnmg.poo2.service.ResponsibleService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class EditarPacientView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	private Long codigo;
	private List<Responsible> respCadastrados;
	private List<Responsible> respAtribuidos;
	private List<Responsible> respCadastradosFiltrados;
	private List<Responsible> respAtribuidosFiltrados;
	private Responsible selectedRespUp;
	private Responsible selectedRespDw;
	private Responsible novoResp;
	private String birthdate;
	
	@Inject
	private ResponsibleService respService;
	
	@Inject
	private PatientService patService;
	
	@PostConstruct
	public void init() {
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
		if(respAtribuidos.contains(selectedRespUp)) {
			JSFUtil.adicionarMensagemErro("Esse Responsável já foi atribuído");
		}
		else {
			respAtribuidos.add(selectedRespUp);
			JSFUtil.adicionarMensagemSucesso("Responsável Atribuído");
		}
	}
	
	public void removerResponsavelAtribuido () {
		respAtribuidos.remove(selectedRespDw);
	}
	
	public void editarPaciente() {
		patient.setResponsibles(respAtribuidos);
		try {
			patient.setBirthdate(new SimpleDateFormat("dd/MM/yyyy").parse(getBirthdate()));
			patService.salvar(patient);
			JSFUtil.adicionarMensagemSucesso("Paciente Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemSucesso(e.getMessage());
		}	
	}
	
	public void carregarEdicao() {
		try {
			patient = patService.buscar(codigo);
			respCadastrados = respService.getResponsibles();
			birthdate = new SimpleDateFormat("dd/MM/yyyy").format(patient.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		System.out.println("Teste" + new SimpleDateFormat("dd/MM/yyyy").format(patient.getBirthdate()));
		respAtribuidos = patient.getResponsibles();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public ResponsibleService getRespService() {
		return respService;
	}

	public void setRespService(ResponsibleService respService) {
		this.respService = respService;
	}

	public PatientService getPatService() {
		return patService;
	}

	public void setPatService(PatientService patService) {
		this.patService = patService;
	}
	
}
