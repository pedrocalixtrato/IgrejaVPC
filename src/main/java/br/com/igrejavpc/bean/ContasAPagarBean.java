package br.com.igrejavpc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.omnifaces.util.Messages;

import br.com.igrejavpc.dao.ContasAPagarDAO;
import br.com.igrejavpc.domain.ContasAPagar;
import br.com.igrejavpc.domain.StatusConta;
import br.com.igrejavpc.filter.ContasAPagarFilter;
import br.com.igrejavpc.util.jsf.ExecutorRelatorio;
import br.com.igrejavpc.util.jsf.FacesUtil;



@Named
@RequestScoped
public class ContasAPagarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ContasAPagar contasAPagar;
	private List<StatusConta> tipos;
	private List<ContasAPagar> contasAPagarL;
	private List<ContasAPagar> contasVencidas;
	private ContasAPagarFilter filtro;
	
	private Date dataInicio;
	private Date dataFim;

	private BigDecimal somarTotal;
	@Inject
	private ContasAPagarDAO contasAPagarDAO;
	@Inject
	private EntityManager em;
	
	
	private FacesContext facesContext ;
	
	private HttpServletResponse response ;
	


	// @Transactional
	public void salvar() {
		try {
			this.contasAPagarDAO.salvar(contasAPagar);
			Messages.addGlobalInfo("Salvo com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Não foi possivel salvar este cadastro");
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {

		this.tipos = Arrays.asList(StatusConta.values());
		this.contasAPagar = new ContasAPagar();

	}
	
	public void excluir(ActionEvent evento){
		
		contasAPagar = (ContasAPagar) evento.getComponent().getAttributes().get("contaSelecionada");
		try{
			contasAPagarDAO.excluir(contasAPagar.getCodigo());
			Messages.addGlobalInfo("Removido com sucesso!");
		}catch(RuntimeException e){
			
			Messages.addGlobalError("Nao foi possivel remover este cadastro");		
			e.printStackTrace();
			
		}
		
		
	}

	public void filtrar() {

		this.contasVencidas = contasAPagarDAO.filtro(filtro);
		this.somarTotal = contasAPagarDAO.somarTotal(filtro);

	}

	public void listar() {

		this.contasAPagarL = contasAPagarDAO.listar(contasAPagar);

	}

	public void carregarCadastro() {

		try {
			String valor = FacesUtil.getParam("contasCod");
			if (valor != null) {

				Long codigo = Long.parseLong(valor);

				this.contasAPagar = em.find(ContasAPagar.class, codigo);

			}

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar os dados do cliente");
			e.printStackTrace();
		}
	}
	
	public void imprimir(){
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("data_inicio", this.filtro.getDataInicial());
		parametros.put("data_fim", this.filtro.getDataFinal());		
		
		
		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/RelatorioContasP.jasper",
				response, parametros, "Relatorio ContasPagar.pdf");
		
		Session session = em.unwrap(Session.class);
		session.doWork(executor);
		
		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
		}
		
	}

	public ContasAPagar getContasAPagar() {
		return contasAPagar;
	}

	public void setContasAPagar(ContasAPagar contasAPagar) {
		this.contasAPagar = contasAPagar;
	}

	public List<StatusConta> getTipos() {
		return tipos;
	}

	public void setTipos(List<StatusConta> tipos) {
		this.tipos = tipos;
	}

	public List<ContasAPagar> getContasAPagarL() {
		return contasAPagarL;
	}

	public void setContasAPagarL(List<ContasAPagar> contasAPagarL) {
		this.contasAPagarL = contasAPagarL;
	}

	public void setContasVencidas(List<ContasAPagar> contasVencidas) {
		this.contasVencidas = contasVencidas;
	}

	public List<ContasAPagar> getContasVencidas() {
		return contasVencidas;
	}

	public ContasAPagarFilter getFiltro() {
		if (filtro == null) {
			filtro = new ContasAPagarFilter();
		}
		return filtro;
	}

	public void setFiltro(ContasAPagarFilter filtro) {
		this.filtro = filtro;
	}

	public BigDecimal getSomarTotal() {
		return somarTotal;
	}

	public void setSomarTotal(BigDecimal somarTotal) {
		this.somarTotal = somarTotal;
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
