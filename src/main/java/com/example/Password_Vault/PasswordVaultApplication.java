package com.example.Password_Vault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Password_Vault.domain.User;
import com.example.Password_Vault.domain.Password;
import com.example.Password_Vault.domain.PasswordRepository;
import com.example.Password_Vault.domain.UserRepository;

@SpringBootApplication
public class PasswordVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordVaultApplication.class, args);
		
		
	}

	@Bean
	public CommandLineRunner demo(PasswordRepository repository, UserRepository urepository) {
		return (args) -> {
			
			repository.save(new Password ("test.com","user","password"));
			repository.save(new Password ("www.facebook.com","testing@gmail.com","12345678"));
			
			User user = new User("diego",
					"$2a$10$AkzWFy0xm43MF4MwpPV/2efMNLWgRrjgr1bOUgqBAErGbm4Sj92o.");
			
					urepository.save(user);
			
			};
		}
}