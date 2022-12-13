package hibernate.tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.tutorial.demo.entity.Student;

public class UpdateStudentById {

	public static void main(String[] args) {


		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int studentId =1;
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setProgrammingLanguage("PHP");
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
				
	}

}
