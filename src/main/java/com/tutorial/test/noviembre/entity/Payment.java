package com.tutorial.test.noviembre.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)

	private int payment_id;
	
	@Column
	private String payment_type;
	
	@Column
	private String payment_amount;
	
	@Column
	private Date payment_date_pay;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Customers customer_payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "payment_order_id", referencedColumnName = "order_id")
	private Orders orders_payment;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Customers getCustomer_payment() {
		return customer_payment;
	}

	public void setCustomer_payment(Customers customer_payment) {
		this.customer_payment = customer_payment;
	}

	public Orders getOrders_payment() {
		return orders_payment;
	}

	public void setOrders_payment(Orders orders_payment) {
		this.orders_payment = orders_payment;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_type=" + payment_type + ", payment_amount="
				+ payment_amount + ", payment_date_pay=" + payment_date_pay + ", customer_payment=" + customer_payment
				+ ", orders_payment=" + orders_payment + ", getPayment_id()=" + getPayment_id() + ", getPayment_type()="
				+ getPayment_type() + ", getPayment_amount()=" + getPayment_amount() + ", getCustomer_payment()="
				+ getCustomer_payment() + ", getOrders_payment()=" + getOrders_payment() + "]";
	}
	
	

}
