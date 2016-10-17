//package br.com.igrejavpc.bean;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.event.ActionEvent;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.persistence.EntityManager;
//
//import org.omnifaces.util.Messages;
//
//import br.com.igrejavpc.dao.ProdutoDAO;
//import br.com.igrejavpc.domain.Produto;
//import br.com.igrejavpc.domain.Unidades;
//import br.com.igrejavpc.util.jsf.FacesUtil;
//
//@SuppressWarnings("serial")
//@Named
//@ViewScoped
//public class ProdutoBean implements Serializable {
//
//	private Produto produto;
//	private List<Unidades> unidades;
//	@SuppressWarnings("unused")
//	private List<Produto> produtos;
//
//	private Long codigoProduto;
//
//	@Inject
//	private ProdutoDAO produtoDAO;
//	@Inject
//	private EntityManager em;
//
//	
//
//	// @Transactional
//	public void excluir(ActionEvent evento) {
//		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
//
//		try {
//			produtoDAO.excluir(produto.getCodigo());
//			this.produtos = produtoDAO.listar(produto);
//			Messages.addGlobalInfo("Removido com sucesso!");
//
//		} catch (RuntimeException e) {
//			Messages.addGlobalError("Não foi possivel remover este cadastro");
//			e.printStackTrace();
//
//		}
//
//	}
//
//	@PostConstruct
//	public void inti() {
//
//		this.produto = new Produto();
//		this.unidades = Arrays.asList(Unidades.values());
//
//	}
//
//	public void carregarCadastro() {
//
//		try {
//			String valor = FacesUtil.getParam("produtoCod");
//			if (valor != null) {
//				Long codigo = Long.parseLong(valor);
//
//				this.produto = produtoDAO.buscarPeloCodigo(codigo);
//			}
//
//			// Busca com cache Inicializaçao Eager em subclasses
//			/*
//			  produto = this.em.createQuery("from Produto p inner join fetch
//			  p.categorias where p.codigo = :codigo" , Produto.class)
//			  .setParameter("codigo", codigo) .getSingleResult();
//			 */
//
//		} catch (RuntimeException e) {
//			Messages.addGlobalError("Erro ao obter os dados do Produto");
//			e.printStackTrace();
//		}
//	}
//
//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//	}
//
//	public List<Unidades> getUnidades() {
//		return unidades;
//	}
//
//	public void setUnidades(List<Unidades> unidades) {
//		this.unidades = unidades;
//	}
//
//	public ProdutoDAO getProdutoDAO() {
//		return produtoDAO;
//	}
//
//	public void setProdutoDAO(ProdutoDAO produtoDAO) {
//		this.produtoDAO = produtoDAO;
//	}
//
//	public Long getCodigoProduto() {
//		return codigoProduto;
//	}
//
//	public void setCodigoProduto(Long codigoProduto) {
//		this.codigoProduto = codigoProduto;
//	}
//
//}
