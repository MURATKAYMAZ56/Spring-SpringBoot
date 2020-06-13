package com.hibernate.db.demo;

import java.util.Random;

import com.hibernate.demo.entitiy.Instructor;
import com.hibernate.demo.entitiy.InstructorDetail;

public class MuratHelperClassCreate {

	private Instructor instructor;
	private InstructorDetail instructorDetail;

	Instructor tempInstructor = new Instructor("Murat", "Kay", "mk@gmail.com");
	InstructorDetail tempInstructorDetail = new InstructorDetail("http:www.go.com", "swimming");

	private  static char consonant[] = { 'a', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v',
			'y', 'z' };

	private char vovels[] = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) {
         createName();
	}

	public void createUser() {

	}
	public  static void createName() {
		
		StringBuilder name=null;
		int rnd= new Random().nextInt(consonant.length);
		System.out.println(rnd);
		
		
		for(char i:consonant) {
			 name=name.append(i);
		}
	}

}
