package hibernate.tutorial.demo;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;
import hibernate.tutorial.demo.entity.StudentCourse;
import hibernate.tutorial.demo.entity.StudentNotes;

public class EagerLazyDemo {

	
	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentNotes.class)
				.addAnnotatedClass(StudentCourse.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try
		{
			//start a transaction
			session.beginTransaction();

			int studentId=2;
			Student theStudent = session.get(Student.class, studentId);
			
			//get Students
			System.out.println("Student: "+theStudent);
			
			//Option 1: call getter method while session is open
			System.out.println("Courses: "+theStudent.getStudentCourse());
			
			//commit transaction
			session.getTransaction().commit();
			
			//session close
			session.close();
			
			System.out.println("\nNow Session is closed!\n");
			
			//since courses are lazy loaded .... this should fail
			System.out.println("Courses: "+theStudent.getStudentCourse());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
			factory.close();
		}
	}

}
