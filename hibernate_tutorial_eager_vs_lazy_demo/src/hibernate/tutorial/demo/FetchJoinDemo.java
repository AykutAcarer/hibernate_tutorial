package hibernate.tutorial.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.tutorial.demo.entity.Student;
import hibernate.tutorial.demo.entity.StudentCourse;
import hibernate.tutorial.demo.entity.StudentNotes;

public class FetchJoinDemo {

	
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
			
			//Option 2:Hibernate query with HQL
			
			// get the Student from database
			int studentId=2;
			
			Query<Student> query =
					session.createQuery("select s from Student s "
							+ "JOIN FETCH s.studentCourse "
							+ "where s.id=:theStudentId",
							Student.class);
			
			//set parameter on query
			query.setParameter("theStudentId", studentId);
			
			//execute query and get student
			Student theStudent = query.getSingleResult();
			System.out.println("Student: "+theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//session close
			session.close();
			
			System.out.println("\nNow Session is closed!\n");
			
			//since courses are lazy loaded .... this should fail
			System.out.println("Courses: "+theStudent.getStudentCourse());
			
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
