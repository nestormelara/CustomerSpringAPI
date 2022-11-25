package com.tutorial.test.noviembre.controller;

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

import java.util.List;
import java.util.Optional;

import com.tutorial.test.noviembre.service.PaymentService;
import com.tutorial.test.noviembre.entity.Payment;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService pay_service;

	
	// all payments
	@GetMapping("/allPayments")
	public ResponseEntity<List<Payment>> getAllPayment() {

		try {
			List<Payment> payments = pay_service.getAllPayments();
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(payments);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	
	//payment by id
	@GetMapping("/PaymentById/{id_payment}")
	public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable int id_payment) {

		try {
			Optional<Payment> payments = pay_service.getPaymentById(id_payment);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(payments);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	//payment by type
	@GetMapping("/PaymentByType")
	public ResponseEntity<List<Payment>> getPaymentByType(@RequestParam String type) {

		try {

			List<Payment> paymentsType = pay_service.getPaymentByType(type);
			HttpHeaders headers = new HttpHeaders();

			return ResponseEntity.ok().headers(headers).body(paymentsType);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
