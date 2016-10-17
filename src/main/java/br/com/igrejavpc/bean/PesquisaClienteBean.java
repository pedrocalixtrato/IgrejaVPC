package br.com.igrejavpc.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.igrejavpc.dao.ClienteDAO;
import br.com.igrejavpc.domain.Cliente;
import br.com.igrejavpc.service.ClienteService;
@Named
@ViewScoped
@SuppressWarnings("serial")
public class PesquisaClienteBean implements Serializable{

	private List<Cliente> clientes;
	private Cliente cliente;
	@Inject
	ClienteDAO clienteDAO;

	@SuppressWarnings("unused")
	@Inject
	private ClienteService clienteService;

	//@PostConstruct
	public void init() {
		
		this.clientes = clienteDAO.filtrar(cliente, "nome");
		
	}
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {if (cliente == null){
		cliente = new Cliente();
	}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
