package hibernate.tutorial.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			String theDateOfBirthStr = "08-08-1986";
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date = null;
			try {
				date = sf.parse(theDateOfBirthStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Student theStudent = new Student("Aykut", "Acarer", date, 1260, "aykut@mail.com", "Germany", "Java");
			session.beginTransaction();			
			session.save(theStudent);			
			session.getTransaction().commit();			
			System.out.println("Done...");
			
		}
		finally {
			factory.close();
		}
	}

}
