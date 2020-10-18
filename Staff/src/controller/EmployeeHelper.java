package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

public class EmployeeHelper {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Staff");

	public void addEmployee(Employee empToAdd) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(empToAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Employee> getEmployeeList() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
		List<Employee> foundEmployees = query.getResultList();
		em.close();
		return foundEmployees;
	}

	public Employee findEmployeeById(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee result = em.find(Employee.class, id);
		em.close();
		return result;
	}

	public void cleanUp() {
		emf.close();
	}

	public void deleteEmployee(Employee toDel) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e where e.id = :id", Employee.class);
		tq.setParameter("id", toDel.getId());
		Employee result = tq.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void editEmployee(Employee toEdit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
