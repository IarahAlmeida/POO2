package br.edu.ifnmg.poo2.lista;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class QuestaoListaView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String selectedCountry;
	private String respContinent;
	
	@Inject
	private QuestaoListaService qs;
	
	public void executar() {
		respContinent = qs.getContry(selectedCountry).getContinent().getName();
	}

	public String getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public String getRespContinent() {
		return respContinent;
	}

	public void setRespContinent(String respContinent) {
		this.respContinent = respContinent;
	}

	public QuestaoListaService getQs() {
		return qs;
	}

	public void setQs(QuestaoListaService qs) {
		this.qs = qs;
	}
}
