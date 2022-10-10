package com.rfagundes.digitalbanc.dtos;

import java.io.Serializable;

import com.rfagundes.digitalbanc.domain.Contas;



public class ContasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
     private Integer id ;
	 private String tipo ;
	 private String numero;
	 private double  saldo ;
	 
	 
	public ContasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public ContasDTO(Contas obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.numero = obj.getNumero();
		this.saldo = obj.getSaldo();
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




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}
