package com.trng.jpa.CustomerJpaLibrary;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name= "orders")

public class Order extends BaseEntity{
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", status=" + status + ", orderDetails="
				+ orderDetails + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderLineItems> orderDetails;
	
	
	@ManyToOne
	@JoinColumn(name = "cus_id")
	private Customer customer;
	
	public Order() {
		
	}

	public Order(String orderDate, String status) {
		
		this.orderDate = orderDate;
		this.status = status;
		
	}
	
	
	

}
