package com.rfagundes.digitalbanc.dtos;

import java.io.Serializable;

import com.rfagundes.digitalbanc.domain.Investimentos;

public class InvestimentosDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	
	
	private Integer id ;
	private String nome ;
	private Double taxa;
	
	
	public InvestimentosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvestimentosDTO(Investimentos obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.taxa = obj.getTaxa();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getTaxa() {
		return taxa;
	}


	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	
	
	
	
	
}
