package com.trng.jpa.CustomerJpaLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrimaryKeyJoinColumn;


@Entity 
@Table(name = "customer_address")
@Setter
@Getter
public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cus_id")
	@GeneratedValue(generator = "gen") 
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
	private int customerId;
	
	
	@Column(name = "street")
	private String street;

	@Column(name = "city", length=30)
	@NotBlank
	private String city;

	@Column(name = "state")
	@NotNull
	private String state;

	@Column(name = "country")
	@Size(min=2, max=75)
	private String country;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;
	

	public Address(String street, String city, String state, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [customerId=" + customerId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}

	public Address() {
		
	}
	
	
	
	
	
	
}
