package com.hibernate.db.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {

			// start a transaction

			session.beginTransaction();
			
			//query students
			List<Student> theStudent= session.createQuery("from Student").getResultList();
			
			
			//display the student
			displayStudents(theStudent);
			
			
			
			//new query for students: lastName="Kaya"
			 theStudent= session.createQuery("from Student s where s.lastName='Kaya'").getResultList();
			
			//display
			
			System.out.println("\nStudents who have last name of Kaya");
			
			displayStudents(theStudent);
			
			
			
			//new query  students: lastName="kaya" OR firstName="Deli"
			theStudent=session.createQuery("from Student s where"
									+" s.lastName='Kaya' OR s.firstName='Deli'").getResultList();	
			
			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
			displayStudents(theStudent);
			
			
			// query student where email  LIKE'gmail.com'
			
			theStudent= session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\n\nStudents who have lemail like gmnail");
			displayStudents(theStudent);
			
			
			
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student tempStudent:theStudent) {
			System.out.println(tempStudent);
		}
	}

}
