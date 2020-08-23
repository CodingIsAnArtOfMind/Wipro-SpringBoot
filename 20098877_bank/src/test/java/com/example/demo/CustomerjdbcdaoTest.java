package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.controller.CustomerResource;
import com.bank.dao.CustomerJbdcDao;
import com.bank.model.Customer;
@RunWith(MockitoJUnitRunner.class)
public class CustomerjdbcdaoTest {

@Mock
CustomerJbdcDao customerjdbcdao;
@InjectMocks
CustomerResource customerResources;
@Before
public void setup(){
    MockitoAnnotations.initMocks(this); //without this you will get NPE
    
}	
@Test
	void retrieveAllCustomerTest() {
		Customer cus = new Customer(1, "customerName", "customerAccountType");
		List<Customer> customer = Arrays.asList(cus);
		try
		{
		when(customerjdbcdao.findAll()).thenReturn(customer);
		List<Customer> actualCus = customerResources.retrieveAllCustomer();
		assertEquals(0, actualCus);
		}
		catch(Exception e)
		{
			
		}
	}
	@Test
	void createUserTest()
	{
		try {
		
		Customer cus = new Customer(1, "customerName", "customerAccountType");
		when(customerjdbcdao.insert(cus)).thenReturn(1);
		assertEquals(true,customerResources.createUser(cus));
		}
		catch(Exception e)
		{
			
		}
		}
	@Test
	void deleteUserTest()
	{
		try {
		Customer cus = new Customer(1, "customerName", "customerAccountType");
		when(customerjdbcdao.deleteById(1)).thenReturn(1);
		}
		catch(Exception e)
		{
			
		}
	}
	@Test
	void findOneTest()
	{
		Customer cus = new Customer(1, "customerName", "customerAccountType");
		List<Customer> customer = Arrays.asList(cus); 
		try
		{
		when(customerjdbcdao.findById(1)).thenReturn(customer);
		List<Customer> actualCus = customerResources.findOne(1);
		assertEquals(0, actualCus);
		}
		catch(Exception e)
		{
			
		}		
	}
}
