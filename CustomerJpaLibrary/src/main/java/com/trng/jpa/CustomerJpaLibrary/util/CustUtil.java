package com.trng.jpa.CustomerJpaLibrary.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.trng.jpa.CustomerJpaLibrary.Address;
import com.trng.jpa.CustomerJpaLibrary.Customer;
import com.trng.jpa.CustomerJpaLibrary.Order;
import com.trng.jpa.CustomerJpaLibrary.OrderLineItems;

public class CustUtil {
	private static Scanner sc = new Scanner(System.in);

	public static Customer readCustomer() {
		Customer customer = new Customer();
		Address cusaddress = new Address();
		System.out.println("Enter Customer Name");
		customer.setCustomerName(sc.next());
		System.out.println("Enter Customer Credit Limit");
		customer.setCreditlimit(sc.nextFloat());
		System.out.println("Enter Customer Street");
		cusaddress.setStreet(sc.next());
		System.out.println("Enter Customer City");
		cusaddress.setCity(sc.next());
		System.out.println("Enter Customer State");
		cusaddress.setState(sc.next());
		System.out.println("Enter Customer Country");
		cusaddress.setCountry(sc.next());
		cusaddress.setCustomer(customer);
		customer.setCustomerAddress(cusaddress);
		return customer;
	
	}

	public static int readOID() {
		
		
		System.out.println("Enter Order Id: ");
		return sc.nextInt();
	}

	public static void closeReader() {
		sc.close();
		
	}

	public static int getSelectedOption() {
		return sc.nextInt();
	}

	public static Customer updatedCustomerRead(Customer loadCustomer) {
		
		Address cusaddress = loadCustomer.getCustomerAddress();
		System.out.println("Enter Customer Name");
		loadCustomer.setCustomerName(sc.next());
		System.out.println("Enter Customer Credit Limit");
		loadCustomer.setCreditlimit(sc.nextFloat());
		System.out.println("Enter Customer Street");
		cusaddress.setStreet(sc.next());
		System.out.println("Enter Customer City");
		cusaddress.setCity(sc.next());
		System.out.println("Enter Customer State");
		cusaddress.setState(sc.next());
		System.out.println("Enter Customer Country");
		cusaddress.setCountry(sc.next());
		cusaddress.setCustomer(loadCustomer);
		loadCustomer.setCustomerAddress(cusaddress);
		return loadCustomer;
		
	}

	public static Order readOrder() {
		Order order = new Order();
		System.out.println("Enter Order Date");
		order.setOrderDate(sc.next());
		System.out.println("Enter Order status");
		order.setStatus(sc.next());
		int option = 0;
		OrderLineItems orlid ;
		Set<OrderLineItems> orlidSet = new HashSet<>();
		do {
			System.out.println("Do You want to add any orderline items? \n1.Yes \n2.No");
			option = sc.nextInt();
			 
			if(option ==1) {
				orlid = new OrderLineItems();
				System.out.println("Enter ProductId");
				orlid.setProduct_id(sc.nextInt());
				System.out.println("Enter price");
				orlid.setPrice(sc.nextFloat());
				System.out.println("Enter quantity");
				orlid.setQuantity(sc.nextInt());
				
				orlid.setOrder(order);
				
				orlidSet.add(orlid);
			}
			
			
		}while(option != 2);
		
		
		order.setOrderDetails(orlidSet);
		
		return order;
	}

	public static Order updatedOrderRead(Order order) {
		System.out.println("Enter Order Date");
		order.setOrderDate(sc.next());
		System.out.println("Enter Order status");
		order.setStatus(sc.next());
		int option = 0;
		OrderLineItems orlid ;
		
		Set<OrderLineItems> orlidSet = order.getOrderDetails();
		do {
			System.out.println("Do You want to add any orderline items? \n1.Yes \n2.No");
			option = sc.nextInt();
			 
			if(option ==1) {
				orlid = new OrderLineItems();
				System.out.println("Enter ProductId");
				orlid.setProduct_id(sc.nextInt());
				System.out.println("Enter price");
				orlid.setPrice(sc.nextFloat());
				System.out.println("Enter quantity");
				orlid.setQuantity(sc.nextInt());
				
				orlid.setOrder(order);
				
				orlidSet.add(orlid);
			}
			
			
		}while(option != 2);
		
		
		order.setOrderDetails(orlidSet);
		
		
		
		return order;
	}

	public static int readCID() {
		System.out.println("Enter Customer Id: ");
		return sc.nextInt();
	}

}
