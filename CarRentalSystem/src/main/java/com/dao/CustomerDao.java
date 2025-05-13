package com.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Customer;
import com.entity.Engine;
import com.entity.Car;

public class CustomerDao {

public static void addCustomer()
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Car car=new Car();
	car.setBrand("Honda");
    car.setModel("Civic");
    
    et.begin();
    em.persist(car);
    et.commit();
    
	Customer cus=new Customer();
	cus.setName("Alex");
	cus.setBookDate(LocalDate.of(2025, 5, 10));
	cus.setReturnDate(LocalDate.of(2025, 5, 20));
	
    cus.setCar(car);
    
	et.begin();
    em.persist(cus);
    et.commit();
    System.out.println("Customer added successfully!");
}

public static void CustomerBookingDetails() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	String jpql="Select cus from Customer cus where cus.id=?1";
	et.begin();
	Query q=em.createQuery(jpql);
	q.setParameter(1,3);
	List<Customer>li=q.getResultList();
	et.commit();
	li.forEach(al->System.out.println(al.getName()+" "+al.getCar()+" "+al.getBookDate()+" "+al.getReturnDate()));

}
}
