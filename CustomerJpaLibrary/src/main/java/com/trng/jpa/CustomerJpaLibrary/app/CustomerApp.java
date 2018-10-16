package com.trng.jpa.CustomerJpaLibrary.app;

import com.trng.jpa.CustomerJpaLibrary.Customer;
import com.trng.jpa.CustomerJpaLibrary.Order;
import com.trng.jpa.CustomerJpaLibrary.dao.CustomerDaoImpl;
import com.trng.jpa.CustomerJpaLibrary.dao.OrdersDaoImpl;
import com.trng.jpa.CustomerJpaLibrary.util.CustUtil;


public class CustomerApp {
	
	public CustomerDaoImpl custimpl = new CustomerDaoImpl();
	public OrdersDaoImpl ordimpl = new OrdersDaoImpl();

	public static void main(String[] args) {
		
		
		CustomerApp app = new CustomerApp();

		OperationEnm operation = null;

		do {

			operation = app.readUserSelection();

			app.processUserOperation(operation);

		} while (operation != OperationEnm.EXIT);
		
		
		
	}
	
	private OperationEnm readUserSelection() {
		System.out.println(
				"\n1.Add an Customer \n2. Display a particular Customer \n3. Update an Customer Details \n4.Remove an Customer \n5.Add an Order \n6. Display an Order \n7.Update an Order \n8. Remove an Order  \n9. Exit");

		// Read user input

		int option = CustUtil.getSelectedOption();

		return OperationEnm.getMatchingOperation(option);
	}
	
	
	private void processUserOperation(OperationEnm operation)  {
		switch (operation) {
		case ADD:
			addCustomer();
			break;

		case REMOVE:
			removeCustomer();
			break;

		case SELECT:
			selectCustomer();
			break;

		case UPDATE:
			updateCustomer();
			break;
		case ADDORDER:
			addOrder();
			break;
		case SELECTORDER:
			selectOrder();
			break;
		case UPDATEORDER:
			updateOrder();
			break;
		case REMOVEORDER:
			removeOrder();
			break;
		case EXIT:
			CustUtil.closeReader();
			System.out.println("Thank You ");
			break;

		default:
			System.out.println("\nInvalid Operation Press 9 to exit the application\n");

		}

	}

	private void removeOrder() {
		int number = CustUtil.readOID();
		boolean flag = ordimpl.deleteOrder(number);
		if (flag) {
			System.out.println("Order got removed");
		} else {
			System.out.println("Order not found");
		}
		
	}

	private void updateOrder() {
		int number = CustUtil.readOID();
		Order order = CustUtil.updatedOrderRead(ordimpl.loadOrder(number));
		
		Order newOrder = ordimpl.updateOrder(order);
		if (newOrder != null) {
			System.out.println("Updated successfully as : "+ newOrder);
		} else {
			System.out.println("Failed to update");
		}
	}

	private void selectOrder() {
		int number = CustUtil.readOID();
		Order order = ordimpl.loadOrder(number);
		if (order == null) {
			System.out.println("No Order found with given ID");
		} else {

			System.out.println(order);
		}
	}

	private void addOrder() {
		int number = CustUtil.readCID();
		Customer customer = custimpl.loadCustomer(number);
		Order order = CustUtil.readOrder();
		order.setCustomer(customer);
		Order newOrder = ordimpl.saveOrder(order);
		if (newOrder != null) {
			System.out.println("Added successfully: "+ newOrder);
		} else {
			System.out.println("Failed to add");
		}
		
	}

	private void updateCustomer() {
		int number = CustUtil.readCID();
		Customer customer = CustUtil.updatedCustomerRead(custimpl.loadCustomer(number));
		
		Customer newCustomer = custimpl.updateCustomer(customer);
		if (newCustomer != null) {
			System.out.println("Updated successfully as : "+ newCustomer);
		} else {
			System.out.println("Failed to update");
		}

	}

	private void selectCustomer() {

		int number = CustUtil.readCID();
		Customer customer = custimpl.loadCustomer(number);
		if (customer == null) {
			System.out.println("No Customer found with given ID");
		} else {

			System.out.println(customer);
		}
	}

	private void addCustomer() {
		Customer customer = CustUtil.readCustomer();

		Customer newCustomer = custimpl.saveCustomer(customer);
		if (newCustomer != null) {
			System.out.println("Added successfully: "+ newCustomer);
		} else {
			System.out.println("Failed to add");
		}

	}

	private void removeCustomer() {

		int number = CustUtil.readCID();
		boolean flag = custimpl.deleteCustomer(number);
		if (flag) {
			System.out.println("Customer got removed");
		} else {
			System.out.println("Customer not found");
		}

	}
	
}
