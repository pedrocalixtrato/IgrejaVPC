package br.com.igrejavpc.domain;

public enum StatusPedido {

	
	ORCAMENTO("Orçamento"), 
	EMITIDO("Emitido"), 
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
