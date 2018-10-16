package com.trng.jpa.CustomerJpaLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payments extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "payment_id")
	private int paymentId;
	
	@ManyToOne
	@JoinColumn(name = "cus_id")
	private Customer customer;
	
	@Column(name = "payment_date")
	private String payment_date;
	
	@Column(name="amount")
	private float amount;
	

}
