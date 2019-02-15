package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Appointment;
import br.edu.ifnmg.poo2.service.AppointmentService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class BuscarConsultaView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Appointment> consultas;
	private List<Appointment> consultasFiltradas;
	private Appointment selectedConsulta;
	
	@Inject
	private AppointmentService consultService;
	
	@PostConstruct
	public void init() {
		try {
			consultas = consultService.getConsultas();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluirConsulta() {
		try {
			consultService.excluir(selectedConsulta);
			consultas = consultService.getConsultas();
			JSFUtil.adicionarMensagemSucesso("Consulta Excluída com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public List<Appointment> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Appointment> consultas) {
		this.consultas = consultas;
	}

	public List<Appointment> getConsultasFiltradas() {
		return consultasFiltradas;
	}

	public void setConsultasFiltradas(List<Appointment> consultasFiltradas) {
		this.consultasFiltradas = consultasFiltradas;
	}

	public Appointment getSelectedConsulta() {
		return selectedConsulta;
	}

	public void setSelectedConsulta(Appointment selectedConsulta) {
		this.selectedConsulta = selectedConsulta;
	}

	public AppointmentService getConsultService() {
		return consultService;
	}

	public void setConsultService(AppointmentService consultService) {
		this.consultService = consultService;
	}
}
