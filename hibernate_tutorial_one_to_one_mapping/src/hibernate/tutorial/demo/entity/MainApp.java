package hibernate.tutorial.demo.entity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;

public class MainApp {

	

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
	
	public static void deleteStudent(Session session, int theStudentId)
	{
		Student theStudent = session.get(Student.class, theStudentId);
		
		if(theStudent != null)
		{
			session.delete(theStudent);
		}
		
		System.out.println("Deleted successfully"); 
	}
	
	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentNotes.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
			//create Student
			//session.save(createStudent());
			
			//delete Student
			deleteStudent(session, 10);
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
