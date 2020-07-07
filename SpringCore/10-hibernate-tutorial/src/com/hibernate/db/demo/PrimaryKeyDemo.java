package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {
			// use the session object to save Java object

			// create a student object

			System.out.println("Creating 4 student object...");

			Student st11 = new Student("Aldiii", "Kaya", "ali@gmail.com");

			Student st22 = new Student("Veli", "Kaydi", "veli@gmail.com");
			Student st33 = new Student("Deli", "Kayacak", "deli@gmail.com");

			// start a transaction

			session.beginTransaction();

			// save the student object
			System.out.println("saving the student...");

			session.save(st11);
			session.save(st22);
			session.save(st33);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
