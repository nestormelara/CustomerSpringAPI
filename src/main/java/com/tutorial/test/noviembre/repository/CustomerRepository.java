package com.tutorial.test.noviembre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorial.test.noviembre.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {
	
	@Query(value="SELECT * FROM customers c WHERE c.adress LIKE %:city%",nativeQuery=true)
	List<Customers>findCustomerByCity(@Param("city") String city);
	
	@Query(value="SELECT * FROM customers c WHERE c.phone_number LIKE %:phone_number%",nativeQuery=true)
	List<Customers>findCustomerByPhone(@Param("phone_number") String phone_number);
	
	@Query(value="SELECT * FROM customers c WHERE c.last_name LIKE %:last%",nativeQuery=true)
	List<Customers>findCustomerByLastName(@Param("last") String last);
    
	@Query(value="SELECT * FROM customers c WHERE c.first_name LIKE %:first%",nativeQuery=true)
	List<Customers>findCustomerByFirstName(@Param("first") String first);
	
}
