package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerEntity;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.AccountRepository;

@RestController
public class CustomerController {
	@Autowired
	AccountRepository si;
	@Autowired 
	CustomerRepository sc;
	
	//GET MAPPING//
	@GetMapping("/customer")
	public List<CustomerEntity> getCustomer()
	{
		return sc.findAll();
	}
	
	@GetMapping("/customer/{id}")
	@ResponseBody
	public Optional<CustomerEntity> getCustomer(@PathVariable("id") int id)
	{
		return sc.findById(id);
	}
	
	
	@PostMapping(path="/customer")
	public CustomerEntity addCustomer(@RequestBody CustomerEntity customerentity) {
		sc.save(customerentity);
		return customerentity;
	}
	
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) throws ResourceNotFoundException {
        return sc.findById(id).map(post-> {
            sc.delete(post);
            return ResponseEntity.ok().build();}).orElseThrow(()-> new ResourceNotFoundException("CustomerId " + id + " not found"));
    }
	
	@PutMapping(path="/customer/{id}")
	public CustomerEntity UpdateCustomer(@PathVariable int id,@Valid @RequestBody CustomerEntity customerentity) throws ResourceNotFoundException {
		return sc.findById(id).map(post -> {
			post.setFname(customerentity.getFname());
			post.setLname(customerentity.getLname());
			post.setId(customerentity.getId());
			post.setEmail(customerentity.getEmail());
			post.setAddress(customerentity.getAddress());
			post.setPhone(customerentity.getPhone());
            return sc.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
	}
	
	
}
