package com.tutorial.test.noviembre.entity;

import jakarta.persistence.Table;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Table (name="orders")
public class Orders {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int order_id;
	@Column
	private String name_order;
	@Column
	private String details;
	@Column
	private float price;
	@Column
	private Date order_date;
	@Column
	private Date order_finish;
	@Column
	private String address_shipping;
	
	
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

    private Customers cus;
	

	public Orders() {
	
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getName_order() {
		return name_order;
	}

	public void setName_order(String name_order) {
		this.name_order = name_order;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getOrder_finish() {
		return order_finish;
	}

	public void setOrder_finish(Date order_finish) {
		this.order_finish = order_finish;
	}

	public String getAddress_shipping() {
		return address_shipping;
	}

	public void setAddress_shipping(String address_shipping) {
		this.address_shipping = address_shipping;
	}

	public Customers getCus() {
		return cus;
	}

	public void setCus(Customers cus) {
		this.cus = cus;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", name_order=" + name_order + ", details=" + details + ", price="
				+ price + ", order_date=" + order_date + ", order_finish=" + order_finish + ", address_shipping="
				+ address_shipping + ", cus=" + cus + "]";
	}
	
	
	
	
	
	
}
