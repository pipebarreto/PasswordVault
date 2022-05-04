package com.example.Password_Vault.web;

import java.util.List;
import java.util.Optional;

import org.soulwing.rot13.Rot13;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Password_Vault.domain.Password;
import com.example.Password_Vault.domain.PasswordRepository;

@Controller
public class PasswordController {

	@Autowired
	private PasswordRepository repository;
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    } 
	
	@RequestMapping("/passwordlist")	
	public String passwordlist(Model model) {
		model.addAttribute("passwords", repository.findAll());
		return "passwordlist";
	}
	
	//Testing for API in the future
    @RequestMapping(value="/passwords", method = RequestMethod.GET)
    public @ResponseBody List<Password> PasswordListRest() {	
        return (List<Password>) repository.findAll();
    } 
//	RESTful for getting password By Id
    @RequestMapping(value="/password/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Password> findBookRest(@PathVariable("id") Long passwordId) {	
    	return repository.findById(passwordId);
    }  
    
    @RequestMapping(value = "/addpassword")
	public String addPassword(Model model){
	model.addAttribute("password", new Password());
	 return "addpassword";
	}

    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Password password){
    	//Testing saving using Rot13
    	/*String coded = Rot13.rotate(password.getKeyword());
    	password.setKeyword(coded);*/
    	repository.save(password);
	 return "redirect:passwordlist";
	}
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePassword(@PathVariable("id") Long passwordId, Model model){
		repository.deleteById(passwordId);
	 return "redirect:../passwordlist";
	}
    
    @RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long passwordId, Model model) {
	model.addAttribute("password", repository.findById(passwordId));
	return "editpassword";
	}
    
}
