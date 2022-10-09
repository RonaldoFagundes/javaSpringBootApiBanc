package com.rfagundes.digitalbanc.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
public class Users implements Serializable{
	
	 
	
	private static final long serialVersionUID = 1L;
	
	
	
	 @Id	 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id ;
	 private String name ;
	 private String login ;
	 private String password;
	 
	
	 
	 
	@OneToMany(mappedBy = "users")
	private List <Contas> contas  = new ArrayList<>();

	
	
	
		
	public Users() {
		super();		
	}

	
	

	public Users(Integer id, String name, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	
	
	
	

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	
	
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

	public List<Contas> getContas() {
		return contas;
	}



	public void setContas(List<Contas> contas) {
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
		Users other = (Users) obj;
		return Objects.equals(id, other.id);
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
