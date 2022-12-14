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

public class MainAppp {

		
	public static Student createStudent()
	{
		
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
		
		//created_at
		Timestamp timestamp_create = new Timestamp(System.currentTimeMillis());
		
		//updated_at
		Timestamp timestamp_update = new Timestamp(System.currentTimeMillis());
		
		
		//create Student objects
		Student theStudent = new Student("Ünal Okan", "Acarer", date, 1001, "okan@mail.com", "Germany", "C++", timestamp_create, timestamp_update);
		
		//create Student notes
		StudentNotes theStudentNotes = new StudentNotes(96, 100, 97, timestamp_create, timestamp_update);
		
		
		//associate the objects
		theStudent.setStudentNotes(theStudentNotes);
		
		return theStudent;
				
	}
	
	public static void createCourse(Session session, int studentId)
	{
		
		//created_at
		Timestamp timestamp_create = new Timestamp(System.currentTimeMillis());
				
		//updated_at
		Timestamp timestamp_update = new Timestamp(System.currentTimeMillis());
		
		//get the student from database
		Student theStudent = session.get(Student.class, studentId);
		
		//create courses
		StudentCourse studentCourse1 = new StudentCourse("English Course", timestamp_create, timestamp_update);
		StudentCourse studentCourse2 = new StudentCourse("German Course", timestamp_create, timestamp_update);
		
		//add courses to student
		theStudent.add(studentCourse1);
		theStudent.add(studentCourse2);
		
		//save courses
		session.save(studentCourse1);
		session.save(studentCourse2);

	}
	
	public static void getStudentsCourse(Session session, int studentId)
	{
		Student theStudent = session.get(Student.class, studentId);
		
		System.out.println("Student: "+ theStudent.getFirstName()+" "+theStudent.getLastName());
		System.out.println("\nCourse: ");
		System.out.println("\n"+theStudent.getStudentCourse());
		
	}
	
	public static void deleteCourseByStudentId(Session session, int studentId)
	{
		Student theStudent = session.get(Student.class, studentId);
		
		session.createQuery("delete from StudentCourse where student ="+studentId+" and "
				+ "courseTitle = 'English Course'").executeUpdate();
	
	}
	
	public static void deleteCourseByCourseId(Session session, int courseId)
	{
		StudentCourse theCourse = session.get(StudentCourse.class, courseId);
		
		session.delete(theCourse);
		
	}
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

//			//create Student and Student Notes
//			session.save(createStudent());
			
//			//add course to student
//			int studentId=2;
//			createCourse(session, studentId);
			
//			//get Course of Student
//			int studentId=2;
//			getStudentsCourse(session, studentId);
//			
//			System.err.println("\n\n");
//			
//			//delete Course by Student id
//			deleteCourseByStudentId(session, studentId);
			
//			//delete Course by Course Id
//			int courseId=2;
//			deleteCourseByCourseId(session, courseId);
			
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
