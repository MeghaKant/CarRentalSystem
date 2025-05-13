package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;

public class EngineDao {
	public static void addEngine()
	  {
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    Engine e=new Engine();
	    e.setType("Diesel");
	     e.setCc(1500.0);
	    et.begin();
	    em.persist(e);
	    et.commit();
	    System.out.println("Car added successfully!");
	}
	  public static void findById(int id)
	    {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    	EntityManager em = emf.createEntityManager();
	    	EntityTransaction et = em.getTransaction();
	    	String jpql="Select e from Engine e where e.id=?1";
			et.begin();
			Query q=em.createQuery(jpql);
			q.setParameter(1,2);
			List<Engine>li=q.getResultList();
			et.commit();
			li.forEach(al->System.out.println(al));
	    	
	    }
	  public static void removeEngine(int engine_id)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    	EntityManager em = emf.createEntityManager();
	    	EntityTransaction et = em.getTransaction();
	    	String sql="Update Car set engine_id=null where id=?1";
	    	
	    	et.begin();
	    	 Query query = em.createNativeQuery(sql);
	 	    query.setParameter(1, engine_id);
	 	    int count = query.executeUpdate();
	 	    System.out.println(count);
	    	et.commit();
	    	
	    	
	  }
	  public static void findAll()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    	EntityManager em = emf.createEntityManager();
	    	EntityTransaction et = em.getTransaction();
	    	String jpql="Select e from Engine e";
	    	et.begin();
	    	Query q=em.createQuery(jpql);
	    	List<Engine>li=q.getResultList();
	    	et.commit();
	    	li.forEach(al->System.out.println(al));
	  }
}