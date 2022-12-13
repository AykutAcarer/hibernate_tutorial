package hibernate.tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.tutorial.demo.entity.Student;

public class ReadStudentById {

	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			Student theStudent = new Student("Feyza", "Acarer", 1001, "feyza@mail.com", "Turkey", "C++");
//			session.beginTransaction();			
//			session.save(theStudent);			
//			session.getTransaction().commit();			
//			System.out.println("Done...");
//			
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Student myStudent = session.get(Student.class, theStudent.getId());		
//			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

	

}
