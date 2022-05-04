package com.example.Password_Vault.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Password {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String page;
	private String user;
	private String keyword;
	
	public Password() {
		
	}
	
	public Password(String page, String user, String keyword) {
		this.page=page;
		this.user=user;
		this.keyword=keyword;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	public String toString() {
		return "Webpage: " + page + "   Username: "+user+ "   Password: "+keyword + " 	id: "+id;
	}
	
}
