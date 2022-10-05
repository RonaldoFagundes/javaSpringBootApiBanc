package com.rfagundes.digitalbanc.domain;

import java.util.Objects;

public class Contas {

	
	 private Integer id ;
	 private String tipo = "";
	 private String numero ="";
	 private double  saldo ;
	 
	 
	 private Users user ;

	 
	 

	public Contas() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Contas(Integer id, String tipo, String numero, double saldo, Users user) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
		this.user = user;
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




	public Users getUser() {
		return user;
	}




	public void setUser(Users user) {
		this.user = user;
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
		Contas other = (Contas) obj;
		return Objects.equals(id, other.id);
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
