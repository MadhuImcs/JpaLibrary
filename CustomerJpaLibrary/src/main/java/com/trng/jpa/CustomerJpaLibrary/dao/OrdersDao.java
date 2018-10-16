package com.trng.jpa.CustomerJpaLibrary.dao;

import java.util.List;

import com.trng.jpa.CustomerJpaLibrary.Order;

public interface OrdersDao {
	Order loadOrder(int id);

	Order saveOrder(Order order);

	Order updateOrder(Order order);

	boolean deleteOrder(int id);
	
	List<Order> getOrders();
}
