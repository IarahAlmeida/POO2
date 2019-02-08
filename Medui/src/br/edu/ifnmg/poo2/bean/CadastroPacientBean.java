package br.edu.ifnmg.poo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.poo2.entity.Address;
import br.edu.ifnmg.poo2.entity.Responsible;

@Named
@ViewScoped
public class CadastroPacientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Address> lazyAddresses;
	private List<Responsible> lazyResponsibles;
	
	
	private List<Responsible> selectResponsibles;
	private Address selectAddress;
	
	@PostConstruct
    public void init() {
        lazyAddresses = addressService.getAddresses();
        lazyResponsibles = responsibleService.getResponsibles();
    }
	
	@Inject
	private AddressService addressService;
	
	@Inject
	private ResponsibleService responsibleService;

	public List<Address> getLazyAddresses() {
		return lazyAddresses;
	}

	public void setLazyAddresses(List<Address> lazyAddresses) {
		this.lazyAddresses = lazyAddresses;
	}

	public List<Responsible> getLazyResponsibles() {
		return lazyResponsibles;
	}

	public void setLazyResponsibles(List<Responsible> lazyResponsibles) {
		this.lazyResponsibles = lazyResponsibles;
	}

	public List<Responsible> getSelectResponsibles() {
		return selectResponsibles;
	}

	public void setSelectResponsibles(List<Responsible> selectResponsibles) {
		this.selectResponsibles = selectResponsibles;
	}

	public Address getSelectAddress() {
		return selectAddress;
	}

	public void setSelectAddress(Address selectAddress) {
		this.selectAddress = selectAddress;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public ResponsibleService getResponsibleService() {
		return responsibleService;
	}

	public void setResponsibleService(ResponsibleService responsibleService) {
		this.responsibleService = responsibleService;
	}
	
	public String Enviar() {
		return "a";
	}

}
