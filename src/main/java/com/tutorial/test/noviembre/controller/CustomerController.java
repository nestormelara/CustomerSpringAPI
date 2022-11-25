package com.tutorial.test.noviembre.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.test.noviembre.entity.Customers;
import com.tutorial.test.noviembre.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customers")

public class CustomerController {

	@Autowired
	CustomerService cus_service;
   
	
	// all customers
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customers>> getCustomers() {
		try {
			List<Customers> custo = cus_service.getCustomersAll();
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custo);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
   
	//Customer By Id customer
	@GetMapping("/customerById/{customerid}")
	public ResponseEntity<Optional<Customers>> getCustomerById(@PathVariable int customerid) {
		try {
			Optional<Customers> custoById = cus_service.getCustomerById(customerid);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custoById);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	//Customer By City
	@GetMapping("/customerByCity")
	public ResponseEntity<List<Customers>> getCustomerByCity(@RequestParam String city) {
		try {
			List<Customers> custoByCity = cus_service.getCustomerByCity(city);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custoByCity);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
     
	
	//customer by phone Number
	@GetMapping("/customerByPhoneNumber")
	public ResponseEntity<List<Customers>> getCustomerByPhoneNumber(@RequestParam String phone_number) {
		try {
			List<Customers> custoByPhone = cus_service.getCustomerByPhoneNumber(phone_number);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custoByPhone);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
    
	//customer by last name
	@GetMapping("/customerByLastName")
	public ResponseEntity<List<Customers>> getCustomerByLastName(@RequestParam String last) {
		try {
			List<Customers> custoByLast = cus_service.getCustomerByLastName(last);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custoByLast);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//customer by first name
	@GetMapping("/customerByFirstName")
	public ResponseEntity<List<Customers>> getCustomerByFirstName (@RequestParam String first){
		try {
			List<Customers> custoByFirst = cus_service.getCustomerByFirstName(first);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(custoByFirst);

		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

}
