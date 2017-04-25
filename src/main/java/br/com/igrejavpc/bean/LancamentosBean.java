package br.com.igrejavpc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import org.omnifaces.util.Messages;

import antlr.debug.Event;
import br.com.igrejavpc.Enum.Obreiro;
import br.com.igrejavpc.Enum.TipoLanc;
import br.com.igrejavpc.dao.LancamentosDAO;
import br.com.igrejavpc.domain.Lancamentos;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LancamentosBean implements Serializable {
	
	private Lancamentos lancamentos;
	private List<TipoLanc> tipo;
	private List<Obreiro> obreiro;
	
	
	@Inject
	private LancamentosDAO lancamentosDAO;
	
	@PostConstruct
	public void init(){
		
		lancamentos = new Lancamentos();
		tipo =  Arrays.asList(TipoLanc.values());
		obreiro = Arrays.asList(Obreiro.values());
		this.lancamentos.setData(new Date());
		
	}
	
	public void salvar(){
		
		try{
			lancamentosDAO.salvar(lancamentos);	
			lancamentos = new Lancamentos();
			Messages.addGlobalInfo("Salvo com sucesso!");
			
			
		}catch(RuntimeException e){
			Messages.addGlobalError("Erro ao salvar este lançamento");
			e.printStackTrace();
		}
		
		
	}
	
	public void excluir(ActionEvent evento){
		
		lancamentos = (Lancamentos)evento.getComponent().getAttributes().get("lancamentoSelecionado");
		
		try{
			lancamentosDAO.excluir(lancamentos.getCondigo());
			Messages.addGlobalInfo("Lançamento removido com sucesso!");
		}catch(RuntimeException e){
			Messages.addGlobalError("Nao foi possivel excluir este cadastro");
			
		}
		
	}
	
	
	

	public Lancamentos getLancamentos() {
		return lancamentos;
	}


	public void setLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}


	public List<TipoLanc> getTipo() {
		return tipo;
	}


	public void setTipo(List<TipoLanc> tipo) {
		this.tipo = tipo;
	}

	public List<Obreiro> getObreiro() {
		return obreiro;
	}

	public void setObreiro(List<Obreiro> obreiro) {
		this.obreiro = obreiro;
	}

	
	
	
	
	

}
