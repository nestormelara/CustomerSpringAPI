package com.tutorial.test.noviembre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorial.test.noviembre.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{

	
	  @Query(value="select * from orders o join customers c on c.customer_id = o.cus_customer_id where o.cus_customer_id =:customer_id", nativeQuery=true)
	  List<Orders> findOrdersByCustomerId (int customer_id);
	 
	@Query (value="select * from orders o where price >=:price" ,  nativeQuery=true)
	List <Orders> findOrdersByPrice(float price);
}
