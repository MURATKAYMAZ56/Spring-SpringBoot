package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Course;
import com.hibernate.demo.entitiy.Instructor;
import com.hibernate.demo.entitiy.InstructorDetail;
import com.hibernate.demo.entitiy.Review;
import com.hibernate.demo.entitiy.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {

			// start a transaction

			session.beginTransaction();

			// create a course

			Course tempCourse = new Course("Murat- How to score a million");
			// save the course
			System.out.println("\nSaving the coiurse");

			session.save(tempCourse);

			System.out.println("Saved the course");

			// create the students

			Student tempStudent1 = new Student("Mu", "Ka", "muka@gmail.com");

			Student tempStudent2 = new Student("Mu2", "Ka", "mu2ka@gmail.com");

			Student tempStudent3 = new Student("Mu3", "Ka", "mu3ka@gmail.com");

			// add students to the course

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			// save the students
			System.out.println("\n Saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved the stundents" + tempCourse.getStudents());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
