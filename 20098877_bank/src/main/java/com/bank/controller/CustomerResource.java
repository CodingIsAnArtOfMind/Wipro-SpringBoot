package com.bank.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bank.Exception.UserNotFoundException;
import com.bank.dao.CustomerJbdcDao;
import com.bank.model.Customer;

@RestController
public class CustomerResource {
	/*
	 * @Autowired private CustomerDaoService customerDaoService;
	 */	
	@Autowired
	CustomerJbdcDao dao;
	
	@GetMapping("/customer")
	public List<Customer> retrieveAllCustomer(){
		List<Customer> list = dao.findAll();
		return list;
	}
	
	
	
	  @GetMapping("/customer/{id}") 
	  public List<Customer> findOne(@PathVariable int id) {
	  List<Customer> customer= dao.findById(id); if(customer==null) throw
	  new UserNotFoundException("id- " + id);
	  
	  return customer;
	  
	  
	  }
	 
	
	  @PostMapping("/customer") 
	  public Boolean createUser(@Valid @RequestBody Customer newCustomer) 
	  { 
		  int userdataSaved = dao.insert(newCustomer);
	  
	  if(userdataSaved!=0) {
		  return true;
	  }
	 
	return false;
	  
	  }
	 
	  
	  @DeleteMapping("/customer/{id}") 
	  public void deleteUser(@PathVariable int id)
	  { int customerDelete = dao.deleteById(id);
	  
	  if(customerDelete==0) throw new UserNotFoundException("id-"+ id); }
	 
}
