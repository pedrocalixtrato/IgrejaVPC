package br.com.igrejavpc.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.omnifaces.util.Messages;

import br.com.igrejavpc.dao.ClienteDAO;
import br.com.igrejavpc.domain.Cliente;
import br.com.igrejavpc.domain.Pessoa;
import br.com.igrejavpc.util.jpa.Transactional;

@SuppressWarnings("serial")
public class ClienteService implements Serializable {

	@Inject
	private ClienteDAO clienteDAO;

	//@Transactional
	public void salvar(Cliente cliente, Pessoa pessoa) {

		try {
			
			cliente.setPessoa(pessoa);
			clienteDAO.salvar(cliente);
			Messages.addGlobalInfo("Salvo com sucesso!");
		} catch (RuntimeException e) {

			Messages.addGlobalError("Não foi possivel salvar este cadastro");
			e.printStackTrace();

		}

	}

	//@Transactional
	public void excluir(Cliente cliente) {
		try {
			this.clienteDAO.excluir(cliente.getCodigo());
			Messages.addGlobalInfo("Removido com sucesso!");
		} catch (RuntimeException e) {

			Messages.addGlobalError("Não foi possivel remover este cadastro");
			e.printStackTrace();

		}
	}

	public List<Cliente> listar(Cliente cliente) {

		return clienteDAO.filtrar(cliente, "nome");

	}

}
