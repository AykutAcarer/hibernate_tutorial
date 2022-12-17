package hibernate.tutorial.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_courses")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int id;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.DETACH, CascadeType.MERGE, 
				CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
				name="course_student",
				joinColumns=@JoinColumn(name="course_id"),
				inverseJoinColumns=@JoinColumn(name="student_id")
				)
	private List<Student> student;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<StudentReview> studentReviews;
	
	
	public StudentCourse() {
		
	}

	public StudentCourse(String courseTitle, Date created_at, Date updated_at) {
		
		this.courseTitle = courseTitle;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<StudentReview> getStudentReviews() {
		return studentReviews;
	}

	public void setStudentReviews(List<StudentReview> studentReviews) {
		this.studentReviews = studentReviews;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", courseTitle=" + courseTitle + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	public void add(StudentReview tempStudentReviews)
	{
		if(studentReviews == null)
		{
			studentReviews = new ArrayList<>();
		}
		
		studentReviews.add(tempStudentReviews);
	}
	
	public void addStudent(Student theStudent)
	{
		if(student == null)
		{
			student = new ArrayList<>();
		}
		
		student.add(theStudent);
	}
	
}
