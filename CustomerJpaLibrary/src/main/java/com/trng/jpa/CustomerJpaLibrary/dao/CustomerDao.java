package com.trng.jpa.CustomerJpaLibrary.dao;

import java.util.List;

import com.trng.jpa.CustomerJpaLibrary.Customer;

public interface CustomerDao {


		Customer loadCustomer(int id);

		Customer saveCustomer(Customer customer);

		Customer updateCustomer(Customer customer);

		boolean deleteCustomer(int id);
		
		List<Customer> getCustomers();
		
		

}

