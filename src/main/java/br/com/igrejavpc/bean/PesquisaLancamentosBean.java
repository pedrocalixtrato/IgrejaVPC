package br.com.igrejavpc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.igrejavpc.dao.LancamentosDAO;
import br.com.igrejavpc.domain.Lancamentos;
import br.com.igrejavpc.filter.LancamentosFilter;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaLancamentosBean implements Serializable{
	
	private List<Lancamentos> lancamentos;
	private Lancamentos lancamento;
	private LancamentosFilter filtro;
	private BigDecimal somarTotal;
	@Inject
	private LancamentosDAO lancamentosDAO;
	
	
	
	public void filtrar(){
		
		this.lancamentos = lancamentosDAO.filtrar(filtro);
		this.somarTotal = lancamentosDAO.somarTotal(filtro);
		
		
	}
	
	

	public List<Lancamentos> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamentos> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamentos getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamentos lancamento) {
		this.lancamento = lancamento;
	}



	public LancamentosFilter getFiltro() {if(filtro == null){
		filtro = new LancamentosFilter();
	}
		return filtro;
	}



	public void setFiltro(LancamentosFilter filtro) {
		this.filtro = filtro;
	}



	public BigDecimal getSomarTotal() {
		return somarTotal;
	}



	public void setSomarTotal(BigDecimal somarTotal) {
		this.somarTotal = somarTotal;
	}
	
	
	
	
}