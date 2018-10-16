package com.trng.jpa.CustomerJpaLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
public class OrderLineItems  extends BaseEntity{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderline_id")
	private int orderLineId;
	
	@Column(name = "price")
	private float price;
	
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name="quantity")
	private int quantity;

	public OrderLineItems(float price, int product_id, int quantity) {
		super();
		this.price = price;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + product_id;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineItems other = (OrderLineItems) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (product_id != other.product_id)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public OrderLineItems() {
		
	}

	@Override
	public String toString() {
		return "OrderLineItems [orderLineId=" + orderLineId + ", price=" + price + ", product_id=" + product_id
				+ ", quantity=" + quantity + "]";
	}

	
	
	
	
}
