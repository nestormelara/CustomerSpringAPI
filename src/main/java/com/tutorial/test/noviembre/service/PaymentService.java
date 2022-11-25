package com.tutorial.test.noviembre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorial.test.noviembre.entity.Payment;

import com.tutorial.test.noviembre.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository pr;
	
	public List<Payment> getAllPayments(){
		return pr.findAll();
	}
	
	public Optional<Payment> getPaymentById(int id_payment){
		
		return pr.findById(id_payment);
	}
	
	
	public List<Payment> getPaymentByType (String type) {
		
		return pr.findPaymentByType(type);
	}
 
}
