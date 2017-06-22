package br.com.igrejavpc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.igrejavpc.Enum.Obreiro;
import br.com.igrejavpc.Enum.TipoLanc;

@SuppressWarnings("serial")
@Entity
public class Lancamentos implements Serializable{
	
	
	private Long condigo;
	private Date data;
	private BigDecimal valor;
	private TipoLanc tipoLanc;
	private Obreiro obreiro;
	private Cliente membro;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCondigo() {
		return condigo;
	}
	public void setCondigo(Long condigo) {
		this.condigo = condigo;
	}
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Enumerated(EnumType.STRING)
	public TipoLanc getTipoLanc() {
		return tipoLanc;
	}
	public void setTipoLanc(TipoLanc tipoLanc) {
		this.tipoLanc = tipoLanc;
	}
	@Enumerated(EnumType.STRING)
	public Obreiro getObreiro() {
		return obreiro;
	}
	public void setObreiro(Obreiro obreiro) {
		this.obreiro = obreiro;
	}
	@ManyToOne
	public Cliente getMembro() {
		return membro;
	}
	public void setMembro(Cliente membro) {
		this.membro = membro;
	}
	
	
	

}
