package com.trng.jpa.CustomerJpaLibrary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.trng.jpa.CustomerJpaLibrary.Customer;
import com.trng.jpa.CustomerJpaLibrary.util.JPAUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer loadCustomer(int id) {
		EntityManager entityManager = getEntityManager();
		try {
			Customer customer = entityManager.find(Customer.class, id);
			return customer;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		EntityManager entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);

			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

	@Override
	public boolean deleteCustomer(int id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Customer cust = entityManager.find(Customer.class, id);
			entityManager.remove(cust);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Query query = getEntityManager().createQuery("from Customer as c order by c.customerName asc");
		return query.getResultList();
	}
	
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

}
