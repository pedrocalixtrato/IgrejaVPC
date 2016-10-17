//package br.com.igrejavpc.bean;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.event.ActionEvent;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import org.omnifaces.util.Messages;
//
//import br.com.igrejavpc.dao.PedidoDAO;
//import br.com.igrejavpc.dao.ProdutoDAO;
//import br.com.igrejavpc.domain.FormaPagamento;
//import br.com.igrejavpc.domain.ItemPedido;
//import br.com.igrejavpc.domain.Pedido;
//import br.com.igrejavpc.domain.Produto;
//import br.com.igrejavpc.domain.StatusPedido;
//
//@SuppressWarnings("serial")
//@Named
//@ViewScoped
//public class PedidoBean implements Serializable {
//	
//	private Pedido pedido;
//	private List<FormaPagamento> formaPagamento;
//	private List<StatusPedido> statusPedido;
//	private List<Produto> produtos;
//	private Produto produto;
//	private List<ItemPedido> itensPedido;
//	private ItemPedido itemPedido;
//	
//	@Inject
//	private PedidoDAO pedidoDAO;
//	
//	@Inject
//	private ProdutoDAO produtoDAO;
//	
//
//	
//	
//	
//	
//	public void salvar(){
//		try{
//			
//			this.pedidoDAO.salvar(pedido);
//			
//		}catch(RuntimeException e){
//			Messages.addGlobalError("Não foi possivel salvar este cadastro");
//			e.printStackTrace();
//		}
//	}
//	
//	@PostConstruct
//	public void init(){
//		this.pedido = new Pedido();		
//		this.formaPagamento = Arrays.asList(FormaPagamento.values());
//		this.produtos = produtoDAO.listar(produto);	
//		this.itensPedido = new ArrayList<>();
//		
//		
//			
//		
//		
//	}
//	
//	public void adcionar(ActionEvent evento){
//		
//		
//		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
//			
//		
//		ItemPedido itemPedido = new ItemPedido();
//		itemPedido.setValorParcial(produto.getValorUnitario());
//		itemPedido.setQuantidade(new BigDecimal(1));
//		itemPedido.setProduto(produto);
//		
//		itensPedido.add(itemPedido);
//		
//	}
//	
//	
//	public Pedido getPedido() {
//		return pedido;
//	}
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
//	public List<FormaPagamento> getFormaPagamento() {
//		return formaPagamento;
//	}
//	public void setFormaPagamento(List<FormaPagamento> formaPagamento) {
//		this.formaPagamento = formaPagamento;
//	}
//	public List<StatusPedido> getStatusPedido() {
//		return statusPedido;
//	}
//	public void setStatusPedido(List<StatusPedido> statusPedido) {
//		this.statusPedido = statusPedido;
//	}
//
//	public List<Produto> getProdutos() {
//		return produtos;
//	}
//
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
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
//	public List<ItemPedido> getItensPedido() {if(itensPedido==null){
//		itensPedido = new ArrayList<>();
//	}
//		return itensPedido;
//	}
//
//	public void setItensPedido(List<ItemPedido> itensPedido) {
//		this.itensPedido = itensPedido;
//	}
//
//	public ItemPedido getItemPedido() {if(itemPedido == null){
//		itemPedido = new ItemPedido();
//	}
//		return itemPedido;
//	}
//
//	public void setItemPedido(ItemPedido itemPedido) {
//		this.itemPedido = itemPedido;
//	}
//
//	
//	
//	
//	
//	
//
//}
