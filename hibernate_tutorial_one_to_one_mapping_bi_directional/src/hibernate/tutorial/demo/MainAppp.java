package hibernate.tutorial.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;
import hibernate.tutorial.demo.entity.StudentNotes;

public class MainAppp {

	public static void getStudentDetails(Session session, int studentNotesId)
	{
		StudentNotes theStudentNotes = session.get(StudentNotes.class, studentNotesId);
		
		System.out.println("Student Notes: "+theStudentNotes);
		System.out.println("\n\n");
		System.out.println("Student: "+ theStudentNotes.getStudent());
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
			
			//get Student and Student Notes from StudentNotes
			int studentNotesId = 4;
			getStudentDetails(session, studentNotesId);
			
			
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
