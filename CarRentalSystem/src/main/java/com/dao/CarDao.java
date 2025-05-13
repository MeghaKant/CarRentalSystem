package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Bike;
import com.entity.Car;
import com.entity.Engine;

public class CarDao {

    public static void addCar()
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Engine e = new Engine();
         e.setType("Diesel");
         e.setCc(1400.0);
  
         et.begin();
         em.persist(e); 
         et.commit();
         
    	 Car car = new Car();
    	 car.setBrand("Thar");
         car.setModel("Mahindra");
        
         car.setEngine(e);

        et.begin();
        em.persist(car);
        et.commit();
        System.out.println("Car added successfully!");
    }
    
    public static void deleteCar(int car_id)
    {   

    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	String sql="Update Car set engine_id=null where id=?1";
    	
    	et.begin();
    	 Query query = em.createNativeQuery(sql);
 	    query.setParameter(1, car_id);
 	    int count = query.executeUpdate();
 	    System.out.println(count);
    	et.commit();
    }
    public static void findById()
    { 
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	String jpql="Select c from Car c where c.id=?1";
		et.begin();
		Query q=em.createQuery(jpql);
		q.setParameter(1,2);
		List<Car>li=q.getResultList();
		et.commit();
		li.forEach(al->System.out.println(al));
    	
    }
    public static void allocateEngine(int car_id,int engine_id)
    {   	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	String sql="Update Car set engine_id=?1 where id=?2";
    	et.begin();
    	Query query=em.createNativeQuery(sql,Car.class);
    	query.setParameter(1, car_id);
    	query.setParameter(2, engine_id);
    	int count=query.executeUpdate();
    	System.out.println(count);
    	et.commit();	
    }
    public static void deallocateEngine(int car_id)
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	String sql="Update Car set engine_id=null where id=?1";
    	et.begin();
    	 Query query = em.createNativeQuery(sql);
    	    query.setParameter(1, car_id);
    	    int count = query.executeUpdate();
    	    System.out.println(count);
    	    et.commit();
    }
  
}

