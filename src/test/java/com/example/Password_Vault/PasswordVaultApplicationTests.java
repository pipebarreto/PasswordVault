package com.example.Password_Vault;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Password_Vault.domain.Password;
import com.example.Password_Vault.domain.PasswordRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PasswordVaultApplicationTests {
	
	@Autowired
	private PasswordRepository repository;

	 
	@Test
	public void CreatePassword() {		
		Password password = new Password("dfgdfg", "dfgfgdg", "jkjkj");	
		repository.save(password);	
		assertThat(password.getId()).isNotNull();			
	}
	
	@Test
	public void DeleteBook() {			
		Password password  = new Password();		
		repository.save(password);	
		int count1=0;
		int count2=0;		
		for (Password password1: repository.findAll()) {
			count1++;
				};
								
		repository.deleteById(password.getId());	
		
		for (Password password2: repository.findAll()) {
			count2++;
				};					
		assertThat(count1).isEqualTo(count2+1);	
	}
	
	@Test
	public void findByPage() {		
	List <Password> passwords = repository.findByPage("www.test.com");
	assertThat(passwords.get(0).getUser()).isEqualTo("user");
		}	
	}
