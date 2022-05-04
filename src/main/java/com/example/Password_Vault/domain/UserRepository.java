package com.example.Password_Vault.domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
