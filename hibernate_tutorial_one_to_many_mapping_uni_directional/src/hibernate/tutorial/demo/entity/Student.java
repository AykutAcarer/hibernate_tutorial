package hibernate.tutorial.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_information")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_day")
	@Temporal(TemporalType.DATE)
	private Date dateofBirth;
	
	@Column(name="school_number")
	private int schoolNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="country")
	private String country;
	
	@Column(name="programming_language")
	private String programmingLanguage;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_notes_id")
	private StudentNotes studentNotes;
	
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="student",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<StudentCourse> studentCourse;
	
	public Student() 
	{
	}

	public Student(String firstName, String lastName, Date dateofBirth, int schoolNumber, String email, String country,
			String programmingLanguage, Date created_at, Date updated_at) 
	{
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofBirth = dateofBirth;
		this.schoolNumber = schoolNumber;
		this.email = email;
		this.country = country;
		this.programmingLanguage = programmingLanguage;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Date getDateofBirth() 
	{
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) 
	{
		this.dateofBirth = dateofBirth;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getProgrammingLanguage() 
	{
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) 
	{
		this.programmingLanguage = programmingLanguage;
	}

	public int getSchoolNumber() 
	{
		return schoolNumber;
	}

	public void setSchoolNumber(int schoolNumber) 
	{
		this.schoolNumber = schoolNumber;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Date getCreated_at() 
	{
		return created_at;
	}


	
	public void setCreated_at(Date created_at) 
	{
		this.created_at = created_at;
	}


	
	public Date getUpdated_at() 
	{
		return updated_at;
	}


	
	public void setUpdated_at(Date updated_at) 
	{
		this.updated_at = updated_at;
	}


	
	public StudentNotes getStudentNotes() 
	{
		return studentNotes;
	}


	
	public void setStudentNotes(StudentNotes studentNotes) 
	{
		this.studentNotes = studentNotes;
	}
	
	

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofBirth="
				+ dateofBirth + ", schoolNumber=" + schoolNumber + ", email=" + email + ", country=" + country
				+ ", programmingLanguage=" + programmingLanguage + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", studentNotes=" + studentNotes + "]";
	}
	
	
	// add convenience methods for bi-directional relationship
	public void add(StudentCourse tempCourse)
	{
		if(studentCourse == null)
		{
			studentCourse = new ArrayList<>();
		}
		
		studentCourse.add(tempCourse);
		tempCourse.setStudent(this);
	}


	
	
	
	


	

	
	
	
	
			
	
}
