package com.app;

import java.util.Scanner;

import com.dao.CarDao;
import com.dao.CustomerDao;
import com.dao.EngineDao;

public class CarApp {
public static void main(String[] args) {
	System.out.println("Car Rental System");
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter your choice");
	System.out.println("Press 1 for add Car");
	System.out.println("Press 2 for delete Car");
	System.out.println("Press 3 for find car by Id");
	System.out.println("Press 4 for Allocate Engine");
	System.out.println("Press 5 for Deallocate Engine");
	System.out.println("Press 6 for add Engine");
	System.out.println("Press 7 for delete Engine");
	System.out.println("Press 8 for find Engine by Id");
	System.out.println("Press 9 for find all engine");
	System.out.println("Press 10 for add customer details");
	System.out.println("Press 11 for find Customer booking details by id");
	int choice=scan.nextInt();
	
	switch(choice)
	{
	 case 1 : CarDao.addCar();
	 break;
	case 2 : CarDao.deleteCar(1);
	break;
	case 3 : CarDao.findById();
	break;
	case 4 : CarDao.allocateEngine(2,2);
	break;
	case 5 : CarDao.deallocateEngine(2);
	break;
	 case 6 : EngineDao.addEngine();
	 break;
	case 7 : EngineDao.removeEngine(2);
	break;
	case 8 : EngineDao.findById(2);
	break;
	case 9 : EngineDao.findAll();
	break;
	case 10 : CustomerDao.addCustomer();
	break;
	case 11 : CustomerDao.CustomerBookingDetails();
	default:
        System.out.println("Invalid choice!");

	}
}
}
