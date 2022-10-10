package com.rfagundes.digitalbanc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Contas implements Serializable{

	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id ;
	 private String tipo ;
	 private String numero;
	 private double  saldo ;
	 
	 
	 
	 
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="id_user")
	 private Users users ;

	 
	 
	 
	 @OneToMany(mappedBy = "contas")
	 private List <Movimentacao> movimentacao  = new ArrayList<>();
	 
	 
	 

	



	public Contas() {
		super();		
	}




	public Contas(Integer id, String tipo, String numero, double saldo, Users users) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
		this.users = users;
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



	
	public Users getUsers() {
		return users;
	}




	public void setUsers(Users users) {
		this.users = users;
	}
	
	

	


	
	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}




	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
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
