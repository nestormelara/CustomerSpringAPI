package com.tutorial.test.noviembre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorial.test.noviembre.entity.Customers;

import com.tutorial.test.noviembre.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired 
	CustomerRepository cr;
	
	
	public List<Customers> getCustomersAll() {
		return cr.findAll();
	}

	public Optional<Customers> getCustomerById(int id) {

		return cr.findById(id);
	}

	public List<Customers> getCustomerByCity(String city) {
		return cr.findCustomerByCity(city);
	}

	public List<Customers> getCustomerByPhoneNumber(String phone_number) {
		return cr.findCustomerByPhone(phone_number);
	}
	
	public List<Customers> getCustomerByLastName(String last_name){
		return cr.findCustomerByLastName(last_name);
	}
	
	public List<Customers> getCustomerByFirstName(String first_name){
		return cr.findCustomerByFirstName(first_name);
	}
	
	
}
