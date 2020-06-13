package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Course;
import com.hibernate.demo.entitiy.Instructor;
import com.hibernate.demo.entitiy.InstructorDetail;
import com.hibernate.demo.entitiy.Review;
import com.hibernate.demo.entitiy.Student;

public class AddCoursesForMarryDemo {

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

			// get the student marry from database
			
			int studentId=2;  ///look  at the db for maary id 
			
			Student  tempStudent=session.get(Student.class, studentId);
			System.out.println("\n Loaded student:"+tempStudent);
			System.out.println("Course:"+tempStudent.getCourses());
			

			/// create more courses
			
			Course tempCourse1= new Course("Rubikk's CUbe- How toi Spped cube");
			Course tempCourse2= new Course("matrix CUbe-play game");
			

			// add student to courses
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			
			// save courses
			System.out.println("Saving the courses");
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
