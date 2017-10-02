package com.krystianminta.hibernate.firstapp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.firstapp.entity.Employee;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		List <Employee> employees = new ArrayList<>();
		
		System.out.println("Creating employees!");
		employees.add(new Employee("Ed", "Dunk", "Meeeeeeems"));
		employees.add(new Employee("Dario", "Cow", "Meeeeeeems"));
		employees.add(new Employee("Slav", "Moustache", "Meeeeeeems"));
		employees.add(new Employee("Mac", "Guide", "FreeSpaceTV"));
		employees.add(new Employee("Al", "Brous", "FreeSpaceTV"));
		employees.add(new Employee("Mat", "Pus", "Smokers"));
		employees.add(new Employee("Jacob", "Bird", "Smokers"));
		employees.add(new Employee("Luka", "Capi", "DartMans"));
		employees.add(new Employee("Mac", "Wood", "DartMans"));
		employees.add(new Employee("Fred", "Dunk", "DartMans"));
		
		
		try {
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("Saving employees!");
		for(Employee employee : employees) {
			System.out.println(employee);
			session.save(employee);
		}
		
		System.out.println("Employees saved!");
		
		session.getTransaction().commit();
		
		employees.clear();
		
		if(employees.isEmpty()) {
			System.out.println("List cleared!");
		} else {
			System.out.println(".clear() doesn`t work!");
		}
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("Employee with id: 13\n" + session.get(Employee.class, 13));
		
		employees = session.createQuery("from Employee e where e.firstName='Mac'").getResultList();
		
		session.getTransaction().commit();
		
		System.out.println("Employees with first name 'Mac'");
		printEmployees(employees);
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, 13);
		
		session.delete(employee);
		System.out.println("Employee with id 13 deleted!");
		
		session.getTransaction().commit();
		
		
		} finally {
			factory.close();
		}
		
	}

	private static void printEmployees(List<Employee> employees) {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
