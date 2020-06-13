package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Instructor;
import com.hibernate.demo.entitiy.InstructorDetail;
import com.hibernate.demo.entitiy.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {
			//create the object
			
			Instructor tempInstructor= new Instructor("Murat","Kay", "mk@gmail.com");
			InstructorDetail tempInstructorDetail= new InstructorDetail("http:www.go.com","swimming");
			
			//associate the object
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//save the instructor
			
			
			
			//Note: this will also save the details objects because of CascadeType.ALL
			
			System.out.println("Saving instructor"+ tempInstructor);
			
			
			
			// start a transaction

			session.beginTransaction();

			session.save(tempInstructor);
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
