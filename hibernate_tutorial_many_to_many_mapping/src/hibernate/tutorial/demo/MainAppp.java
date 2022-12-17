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
	
	public static void createOneCourseMoreStudents(Session session, Student theStudent1, Student theStudent2, StudentCourse theCourse)
	{	
		//create course
		session.save(theCourse);
		
		//add students to the course
		theCourse.addStudent(theStudent1);
		theCourse.addStudent(theStudent2);
		
		//save student
		session.save(theStudent1);
		session.save(theStudent2);
	}
	
	public static void createOneStudentMorecourses(Session session, StudentCourse theCourse1, StudentCourse theCourse2, Student theStudent)
	{	
		//create course
		session.save(theStudent);
		
		//add students to the course
		theStudent.addCourse(theCourse1);
		theStudent.addCourse(theCourse2);
		
		//save student
		session.save(theCourse1);
		session.save(theCourse2);
		
	}
	
	public static void getCoursesStudent(Student theStudent)
	{
		
		System.out.println("Student: "+theStudent);
		System.out.println("Courses: "+theStudent.getStudentCourse());
		System.out.println("\n");
		
		List<StudentCourse> theCourses = theStudent.getStudentCourse();
		for(StudentCourse theCourse : theCourses)
		{
			System.out.println(theCourse.getId()+" "+theCourse.getCourseTitle());
			System.out.println("\n");
		}
	}
		
	public static void deleteCourse(Session session, StudentCourse theCourse)
	{
		System.out.println("Deleting course: "+ theCourse);
		session.delete(theCourse);
	}
	
	public static void deleteStudent(Session session, Student theStudent)
	{
		System.out.println("Deleting Student: "+ theStudent);
		session.delete(theStudent);
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
			
			//create birthday
			String theDateOfBirthStr = "15-01-2018";
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date = null;
			try {
				date = sf.parse(theDateOfBirthStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Timestamp timestamp_create = new Timestamp(System.currentTimeMillis());
			Timestamp timestamp_update = new Timestamp(System.currentTimeMillis());
						
//			//create Course Object
//			StudentCourse theCourse = new StudentCourse("SpringBoot Course", timestamp_create, timestamp_update);
//	
//			//create Student object
//			Student theStudent1 = new Student("Max", "Mustermann", date, 1234, "okan@mail.com", "USA", "JavaScript", timestamp_create, timestamp_update);
//			Student theStudent2 = new Student("Maxi", "Musterfrau", date, 4321, "sedef@mail.com", "France", "Cobol", timestamp_create, timestamp_update);
//			
//			//create one course more students
//			createOneCourseMoreStudents(session, theStudent1, theStudent2, theCourse);
			
			
			
//			//create Student object
//			Student theStudent = new Student("Ahmet", "Acarer", date, 1111, "ahmet@mail.com", "Turkey", "C#", timestamp_create, timestamp_update);
//			
//			//create Course Objects
//			StudentCourse theCourse1 = new StudentCourse("Laravel Course", timestamp_create, timestamp_update);
//			StudentCourse theCourse2 = new StudentCourse("MVC Course", timestamp_create, timestamp_update);
//			
//			//create one student more courses
//			createOneStudentMorecourses(session,  theCourse1,  theCourse2, theStudent);
			
			
			
//			//get Student from database
//			int theStudentId = 3;
//			Student theStudent = session.get(Student.class, theStudentId);
//			
//			//get Courses
//			getCoursesStudent(theStudent);
//			
			
//			//get Course from Database
//			int courseId =5;
//			StudentCourse theCourse = session.get(StudentCourse.class, courseId);
//			
//			//delete Course
//			deleteCourse(session, theCourse);
			
			
			//get Student from Database
			int theStudentId=7;
			Student theStudent = session.get(Student.class, theStudentId);
			
			//delete Student
			deleteStudent(session, theStudent);
			
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
