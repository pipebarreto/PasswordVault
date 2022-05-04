package com.example.Password_Vault.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<Password, Long> {
	
	List<Password> findByPage(String page);

}