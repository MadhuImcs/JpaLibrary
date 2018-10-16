package com.trng.jpa.CustomerJpaLibrary;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "customer")
@Getter
@Setter
public class Customer extends BaseEntity {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(creditlimit);
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
		Customer other = (Customer) obj;
		if (Float.floatToIntBits(creditlimit) != Float.floatToIntBits(other.creditlimit))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cus_id")
	private int customerId;
	@Column(name = "cus_name")
	private String customerName;
	
	@Column(name="creditlimit")
	private float creditlimit;
	
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address customerAddress;
	
	@OneToMany(mappedBy = "customer",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Order> customerOrders;
	
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Payments> payments;
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", creditlimit=" + creditlimit
				+ ", customerAddress=" + customerAddress + ", customerOrders=" + customerOrders + "]";
	}
 
	
}
