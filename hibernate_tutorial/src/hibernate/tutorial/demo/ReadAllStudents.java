package hibernate.tutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;

public class ReadAllStudents {

	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//query Students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			System.out.println("Show all Students in Database");
			displayStudents(theStudents);
			
			
			//query students: country = "Germany"
			theStudents = session.createQuery("from Student where country='Germany'").list();
			
			System.out.println("\n\nShow student whose country is Germany in Database");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			
		
		}
		finally {
			factory.close();
		}
	}

	
	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	

}
