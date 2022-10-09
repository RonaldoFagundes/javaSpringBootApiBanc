package com.rfagundes.digitalbanc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Investimentos implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nome ;
	private Double taxa;
	
	
	
	
	public Investimentos() {
		super();		
	}




	public Investimentos(Integer id, String nome, Double taxa) {
		super();
		this.id = id;
		this.nome = nome;
		this.taxa = taxa;
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
		Investimentos other = (Investimentos) obj;
		return Objects.equals(id, other.id);
	} 
	
	
	
	

}
