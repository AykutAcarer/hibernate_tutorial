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
import hibernate.tutorial.demo.entity.StudentReview;

public class MainAppp {
	
	public static void createReview(Session session, Student theStudent, StudentCourse theCourse)
	{
		//Create reviews and add reviews to the Course
		theCourse.add(new StudentReview("testetstasdasd", null, null));
		theCourse.add(new StudentReview("hahahahhahas", null, null));
		
		//create course
		session.save(theCourse);
		
		//add course to student
		theStudent.add(theCourse);
		
		//save student
		session.save(theStudent);
	}
	
	public static void getCourseReviews(Session session, int courseId)
	{
		StudentCourse theCourse = session.get(StudentCourse.class, courseId);
		
		System.out.println("Course: "+ theCourse); 
		System.out.println("\nReviews: ");
		System.out.println("\n"+theCourse.getStudentReviews());
		
	}
	
	public static void deleteCourseAndReviews(Session session, int courseId) 
	{
		StudentCourse studentCourse = session.get(StudentCourse.class, courseId);
		
		session.delete(studentCourse);
	}
	
	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentNotes.class)
				.addAnnotatedClass(StudentCourse.class)
				.addAnnotatedClass(StudentReview.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
//			//student id
//			int theStudentId =2;
//			
//			// get student from database
//			Student theStudent = session.get(Student.class, theStudentId);
//			
//			//create Course Object
//			StudentCourse theCourse = new StudentCourse("Java Course", null, null);
//	
//			//create Reviews
//			createReview(session, theStudent, theCourse);
//			
//			// get Course and Reviews of this Course
//			getCourseReviews(session, theCourse.getId());
			
			
			//course id
			int theCourseId =2;
			//delete course and reviews of this course
			deleteCourseAndReviews(session,  theCourseId);
			
			
			//commit transaction
			session.getTransaction().commit();
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
