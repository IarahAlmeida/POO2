package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.edu.ifnmg.poo2.entity.Responsible;
import br.edu.ifnmg.poo2.service.ResponsibleService;
import br.edu.ifnmg.poo2.util.JSFUtil;

@Named
@ViewScoped
public class BuscarResponsavelView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Responsible> responsibles;
	private List<Responsible> responsiblesFiltrados;
	private Responsible selectedResponsible;
	
	@Inject
	private ResponsibleService responsibleService;
	
	@PostConstruct
	public void init() {
		try {
			responsibles = responsibleService.getResponsibles();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluirResponsible() {
		try {
			responsibleService.excluir(selectedResponsible);
			responsibles = responsibleService.getResponsibles();
			JSFUtil.adicionarMensagemSucesso("Responsável Excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public List<Responsible> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(List<Responsible> responsibles) {
		this.responsibles = responsibles;
	}

	public List<Responsible> getResponsiblesFiltrados() {
		return responsiblesFiltrados;
	}

	public void setResponsiblesFiltrados(List<Responsible> responsiblesFiltrados) {
		this.responsiblesFiltrados = responsiblesFiltrados;
	}

	public Responsible getSelectedResponsible() {
		return selectedResponsible;
	}

	public void setSelectedResponsible(Responsible selectedResponsible) {
		this.selectedResponsible = selectedResponsible;
	}

	public ResponsibleService getResponsibleService() {
		return responsibleService;
	}

	public void setResponsibleService(ResponsibleService responsibleService) {
		this.responsibleService = responsibleService;
	}
}
