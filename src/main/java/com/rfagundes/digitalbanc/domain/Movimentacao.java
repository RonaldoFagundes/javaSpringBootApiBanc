package com.rfagundes.digitalbanc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Movimentacao implements Serializable {
	
     
	private static final long serialVersionUID = 1L;
	
	
	
	 @Id	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id ;
	 private String tipo ;	 
	 private String descricao;
	 private double  valor ;
	
	 
	 
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="conta_id")
	 private Contas contas ;
	 
	 
	 
	 
	 
	 public Movimentacao() {
		super();
	 }


	 
	 

	public Movimentacao(Integer id, String tipo,  String descricao, double valor, Contas contas) {
		super();
		this.id = id;
		this.tipo = tipo;
	    this.descricao = descricao;
		this.valor = valor;
		this.contas = contas;
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


	
	

	public Contas getContas() {
		return contas;
	}

	public void setContas(Contas contas) {
		this.contas = contas;
	}


	
	



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}
	
	 
	 
	

}
