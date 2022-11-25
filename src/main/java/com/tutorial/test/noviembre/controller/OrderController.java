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
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.test.noviembre.entity.Orders;

import com.tutorial.test.noviembre.service.OrdersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrdersService ord;
	
	
	//all orders
	@GetMapping("/allOrders")
	public ResponseEntity<List<Orders>> getOrdersAll() {
		try {
			List<Orders> or = ord.OrdersAll();
			
			/*
			 * List<String> ord = or.stream() .filter(o -> o.getPrice()>=45) .map(i ->
			 * i.getCus().getFirst_name() + " " + i.getCus().getLast_name())
			 * .collect(Collectors.toList());
			 * 
			 * System.out.println("Nombre de clientes con  ordenes mayores a $45" + ord);
			 */
			
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(or);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
     
	
	//orders by Id
	@GetMapping("/orderById/{orderid}")
	public ResponseEntity<Optional<Orders>> getOrderById(@PathVariable int orderid) {

		try {
			Optional<Orders> or_id = ord.getOrderById(orderid);
			HttpHeaders headers = new HttpHeaders();
			System.out.println(or_id);
			return ResponseEntity.ok().headers(headers).body(or_id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

	}

	
	// Orders by Customer id
	@GetMapping("/orderByCustomerId/{customer_id}")
	public ResponseEntity<List<Orders>> getOrderByCustomerId(@PathVariable int customer_id) {

		try {
			List<Orders> ord_cus = ord.findOrdersByCustomerId(customer_id);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(ord_cus);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	//Orders by price
	@GetMapping("/orderByPrice/{price}")
	public ResponseEntity<List<Orders>> getOrderByPrice(@PathVariable float price) {
		try {
			List<Orders> ord_pr = ord.findOrdersByPrice(price);
			HttpHeaders headers = new HttpHeaders();
			return ResponseEntity.ok().headers(headers).body(ord_pr);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	  

}