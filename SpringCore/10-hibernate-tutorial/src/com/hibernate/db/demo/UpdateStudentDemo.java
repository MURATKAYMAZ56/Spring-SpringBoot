package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int studentId = 1;

			// update first name to Delioglan
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating the student");
			
			System.out.println("current name:" + myStudent.getFirstName());
			
			myStudent.setFirstName("Delioglan");
			
			System.out.println("First name is updated as" + myStudent.getFirstName());

			
			
			
			
			//NEW CODE---> update all email s
			
			session = factory.getCurrentSession();
			session.getTransaction();
			
			//update emails for all stiudents
			
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			
			
			
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
