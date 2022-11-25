package com.tutorial.test.noviembre.entity;

import jakarta.persistence.Table;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table (name="customers")
public class Customers {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int customer_id;

	@Column
	private String adress;
	
	@Column
	private Date date_birthday;
	
	@Column
	private String email;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String phone_number;
	
	
	public Customers() {
		
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDate_birthday() {
		return date_birthday;
	}

	public void setDate_birthday(Date date_birthday) {
		this.date_birthday = date_birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	

	
	

}
