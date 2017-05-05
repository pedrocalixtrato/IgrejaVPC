package br.com.igrejavpc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.igrejavpc.filter.ContasAPagarFilter;
import br.com.igrejavpc.util.jsf.ExecutorRelatorio;
import br.com.igrejavpc.util.jsf.FacesUtil;

@Named
@RequestScoped
public class ImprimirRelatorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContasAPagarFilter filtro;
	
	private Date dataInicio;
	private Date dataFim;
	
	@Inject
	private EntityManager em;	
	@Inject
	private FacesContext facesContext ;
	@Inject
	private HttpServletResponse response ;
	
	public void imprimir() {

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("data_inicio", this.dataInicio);
		parametros.put("data_fim", this.dataFim);

		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/ContasAPagar.jasper", this.response, parametros,
				"Relatorio ContasPagar.pdf");

		Session session = em.unwrap(Session.class);
		session.doWork(executor);

		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
		}

	}

	public ContasAPagarFilter getFiltro() {if(filtro == null){
		filtro = new ContasAPagarFilter();
	}
		return filtro;
	}

	public void setFiltro(ContasAPagarFilter filtro) {
		this.filtro = filtro;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
		
	

}
