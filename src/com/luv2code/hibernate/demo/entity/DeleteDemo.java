package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("process started");
			
			session.beginTransaction();
			
			int id=1;
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			session.delete(tempInstructor);

			
			session.getTransaction().commit();
			
			System.out.println("Process finished successfully");
			
		} finally {
			factory.close();
		}
		}
}
