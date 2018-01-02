package com.tellusko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

//		Laptop[] laps = new Laptop[5];
//		Alien[] aliens = new Alien[5];
//
//		for (int i = 0; i < 5; i++) {
//			Laptop lap = new Laptop();
//			lap.setLid(i);
//			lap.setBrand("Brand" + i);
//			lap.setPrice(new Random().nextInt(1000));
//			laps[i] = lap;
//			session.save(laps[i]);
//
//			aliens[i] = new Alien();
//			aliens[i].setAid(5001 + i);
//			aliens[i].setLaptop(laps[i]);
//		}
//
//		aliens[0].setAname("Teju");
//		aliens[1].setAname("Kamil");
//		aliens[2].setAname("DP");
//		aliens[3].setAname("Bhuvi");
//		aliens[4].setAname("Vijay");
//
//		for (int i = 0; i < 5; i++) {
//			session.save(aliens[i]);
//		}

		

		 Criteria laptopCriteria = session.createCriteria(Laptop.class);
		 laptopCriteria.add(Restrictions.gt("price", 500));
		 List<Laptop> fetchedLaps = laptopCriteria.list();
		 
		 List<Integer> fetchedLaptopIds = new ArrayList();
		 for (Laptop laptop : fetchedLaps) {			 
			 fetchedLaptopIds.add(laptop.getLid());		
		 }
		 
		 Criteria alienCriteria = session.createCriteria(Alien.class);
		 alienCriteria.add(Restrictions.in("laptop_lid", fetchedLaptopIds));
		 List<Alien> fetchedAliens = alienCriteria.list();
		 System.out.println("List of alien names whose laptop price is greater than $500");
		 System.out.println("-----------------------------------------------------------");
		 for (Alien alien : fetchedAliens) {
			System.out.println(alien.getAname());
		}


		// System.out.println(l);
		session.getTransaction().commit();

	}
}
