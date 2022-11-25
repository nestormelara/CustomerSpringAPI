package com.tutorial.test.noviembre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorial.test.noviembre.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	
	@Query(value="SELECT * FROM payment p WHERE p.payment_type LIKE %:type%" , nativeQuery=true)
	List<Payment> findPaymentByType (String type);
}
