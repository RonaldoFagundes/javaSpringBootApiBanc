package com.rfagundes.digitalbanc.dtos;

import java.io.Serializable;

import com.rfagundes.digitalbanc.domain.Users;

public class UsersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String login;
	private String password;

	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersDTO(Users obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.login = obj.getLogin();
		this.password = obj.getPassword();
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

}
