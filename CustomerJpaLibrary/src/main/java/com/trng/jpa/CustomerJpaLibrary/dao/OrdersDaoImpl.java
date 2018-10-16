package com.trng.jpa.CustomerJpaLibrary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.trng.jpa.CustomerJpaLibrary.Customer;
import com.trng.jpa.CustomerJpaLibrary.Order;
import com.trng.jpa.CustomerJpaLibrary.util.JPAUtil;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public Order loadOrder(int id) {
		EntityManager entityManager = getEntityManager();
		try {
			Order order = entityManager.find(Order.class, id);
			//Hibernate.initialize(order.getOrderDetails());
			return order;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Order saveOrder(Order order) {
		EntityManager entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(order);

			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(order);
		entityManager.getTransaction().commit();
		return order;
	}

	@Override
	public boolean deleteOrder(int id) {
		
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Order order = entityManager.find(Order.class, id);
			Customer customer = order.getCustomer();
			customer.getCustomerOrders().remove(order);
			entityManager.merge(customer);
			entityManager.remove(order);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrders() {
		Query query = getEntityManager().createQuery("from orders ");
		return query.getResultList();
	}
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

}
