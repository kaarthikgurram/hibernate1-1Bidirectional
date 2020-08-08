package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
			
			InstructorDetail instructorDetail = new InstructorDetail();
			
			instructorDetail.setYoutubeChannel("Java Learning channel");
			instructorDetail.setHobby("Teaching");
			
			Instructor instructor = new Instructor();
			
			instructor.setFirst_name("karthik");
			instructor.setLast_name("Gurram");
			instructor.setEmail("kaarthik4all@gmail.com");
			instructor.setInstructorDetail(instructorDetail);
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Process finished successfully");
			
		} finally {
			factory.close();
		}
		}
}
