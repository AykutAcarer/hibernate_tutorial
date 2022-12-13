package hibernate.tutorial.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;
import hibernate.tutorial.demo.entity.StudentNotes;

public class MainAppp {

	public static void getStudentByStudentNotesId(Session session, int studentNotesId)
	{
		StudentNotes theStudentNotes = session.get(StudentNotes.class, studentNotesId);
		
		System.out.println("Student Notes: "+theStudentNotes);
		System.out.println("\n\n");
		System.out.println("Student: "+ theStudentNotes.getStudent());
	}
	
	public static void deleteStudentByStudentNotesId(Session session, int studentNotesId)
	{
		StudentNotes theStudentNotes = session.get(StudentNotes.class, studentNotesId);
		
		session.delete(theStudentNotes);
		
		System.out.println("\n\n deleted Successfuly");
	}
	
	public static void deleteJustStudentNotes(Session session, int studentNotesId)
	{
		StudentNotes theStudentNotes = session.get(StudentNotes.class, studentNotesId);
		
		theStudentNotes.getStudent().setStudentNotes(null);
		
		session.delete(theStudentNotes);
		
		System.out.println("deleted Successfully");
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
//			
//			//get Student and Student Notes from StudentNotes
//			int studentNotesId = 4;
//			getStudentByStudentNotesId(session, studentNotesId);
//			
//			//delete Student and Students Notes from studentNotes Id
//			deleteStudentByStudentNotesId(session, studentNotesId);
			
			//delete just Student Notes 
			int studentNotesId = 6;
			deleteJustStudentNotes(session, studentNotesId);
			
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
