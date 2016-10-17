package br.com.igrejavpc.Enum;

public enum Obreiro {
	
	PEDRO_MIGUEL("Pedro Miguel"),
	MARIO_JUNIOR("Mario Junior"),
	MARCOS_RIBEIRO("Marcos Ribeiro");
	
	
	private String descricao;

	Obreiro(String descricao){		
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
		
	}	
	

}
