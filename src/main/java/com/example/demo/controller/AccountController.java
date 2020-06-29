package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;


@RestController
public class AccountController {
	@Autowired
	AccountRepository si;
	
	@Autowired
	CustomerRepository sc;
	
	
	 @PostMapping("/customer/{id}/account")
	public AccountEntity createAccount(@PathVariable (value = "id") int id, @Valid @RequestBody AccountEntity accountentity) throws ResourceNotFoundException {
	        return sc.findById(id).map(post->{
	            accountentity.setCustomerentity(post);
	            return si.save(accountentity);
	        }).orElseThrow(()-> new ResourceNotFoundException("CustomerId " + id + " not found"));
	    }
	 @PutMapping("/customer/{id}/account/{act_number}")
	    public AccountEntity updateAccount(@PathVariable (value = "id") int id, @PathVariable (value = "act_number") int act_number, @Valid @RequestBody AccountEntity accountentity) throws ResourceNotFoundException {
	        if(!sc.existsById(id)) {
	            throw new ResourceNotFoundException("CustomerId " + id + " not found");
	        }

	        return si.findById(act_number).map(comment-> {
	            comment.setAct_balance(accountentity.getAct_balance());
	            comment.setAct_number(accountentity.getAct_number());
	            comment.setCustomerentity(accountentity.getCustomerentity());
	            return si.save(comment);
	        }).orElseThrow(() -> new ResourceNotFoundException("AccountId " + act_number + "not found"));
	    }
	

	   
	
//	@GetMapping("/account")
//	public List<AccountEntity> getAccount()
//	{
//		return si.findAll();
//	}
////	
//	@GetMapping("/account/{act_number}")
//	public ResponseEntity <AccountEntity> getAccountById(@PathVariable(value="act_number") int act_number) throws ResourceNotFoundException
//	{
//		 AccountEntity user= si.findById(act_number).orElseThrow(()->new ResourceNotFoundException("Account not found"));
//		 return ResponseEntity.ok().body(user);
//	}
//	
	@DeleteMapping("/account/{act_number}")
	public Map < String, Boolean > deleteAccount(@PathVariable(value="act_number")int act_number) throws ResourceNotFoundException {
		AccountEntity a =si.findById(act_number).orElseThrow(()-> new ResourceNotFoundException("Account not found :: " + act_number));
		si.delete(a);
		 Map < String, Boolean > response = new HashMap < > ();
	      response.put("deleted", Boolean.TRUE);
	       return response;
	}
	
}
