package com.rfagundes.digitalbanc.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
     private Integer id ;
	 private String name = "";
	 private String login ="";
	 private String password="";
	 
	 
	 private List<Contas> contas = new ArrayList<>();


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(Integer id, String name, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
