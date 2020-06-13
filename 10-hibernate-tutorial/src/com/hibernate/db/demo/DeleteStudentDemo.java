package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {
			int studentId = 3;
			// start a transaction

			session.beginTransaction();
			
			
			
				//a way to delete 
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting student: " + myStudent.getFirstName() 
			+ " with Id : " + myStudent.getId());
			session.delete(myStudent);
			
			
			// another  way to do it
			session.createQuery("delete from Student where id=2").executeUpdate();

			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
