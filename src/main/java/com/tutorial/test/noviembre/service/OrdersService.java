package com.tutorial.test.noviembre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.test.noviembre.entity.Orders;

import com.tutorial.test.noviembre.repository.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired 
	
	OrdersRepository order;
	
	
	@Transactional
	public List<Orders> OrdersAll(){
		
		return order.findAll();
	}
	
	@Transactional
	public Optional<Orders> getOrderById(int id){
		
		return order.findById(id);
	}
	
	
	
	@Transactional
	public List<Orders> findOrdersByCustomerId(int customer_id) {

		return order.findOrdersByCustomerId(customer_id);
	}

	@Transactional
	public List<Orders> findOrdersByPrice(float price) {
		
		System.out.println(price);

		return order.findOrdersByPrice(price);

	}

}
