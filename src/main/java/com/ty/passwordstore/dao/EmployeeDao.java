package com.ty.passwordstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.passwordstore.dto.Employee;

public class EmployeeDao {

	public Employee saveEmployee(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("deepak");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	public Employee validateEmployee(String name, String phone) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("deepak");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "SELECT e FROM  Employee e WHERE e.name =?1 AND  e.phone = ?2";
		Query query = entityManager.createQuery(sql);

		query.setParameter(1, name);
		query.setParameter(2, phone);

		List<Employee> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		} else
			return null;

	}
}
