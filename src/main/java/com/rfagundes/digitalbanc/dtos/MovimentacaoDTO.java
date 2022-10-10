package com.rfagundes.digitalbanc.dtos;

import java.io.Serializable;

import com.rfagundes.digitalbanc.domain.Movimentacao;

public class MovimentacaoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	 private Integer id ;
	 private String tipo ;	 
	 private String descricao;
	 private double  valor ;
	 
	 
	 
	public MovimentacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public MovimentacaoDTO(Movimentacao obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.descricao = obj.getDescricao();
		this.valor = obj.getValor();
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public double getValor() {
		return valor;
	}




	public void setValor(double valor) {
		this.valor = valor;
	}
	
	 
	
	 

}
