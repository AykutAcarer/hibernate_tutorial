package hibernate.tutorial.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_notes")
public class StudentNotes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="math")
	private int mathNotes;
	
	@Column(name="physics")
	private int physicsNotes;
	
	@Column(name="chemistry")
	private int chemistryNotes;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	@OneToOne(mappedBy="studentNotes", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Student student;
	
	public StudentNotes() 
	{
	}

	

	public StudentNotes(int mathNotes, int physicsNotes, int chemistryNotes, Date created_at, Date updated_at) 
	{
		this.mathNotes = mathNotes;
		this.physicsNotes = physicsNotes;
		this.chemistryNotes = chemistryNotes;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.student = student;
	}



	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getMathNotes() 
	{
		return mathNotes;
	}

	public void setMathNotes(int mathNotes) 
	{
		this.mathNotes = mathNotes;
	}

	public int getPhysicsNotes() 
	{
		return physicsNotes;
	}

	public void setPhysicsNotes(int physicsNotes) 
	{
		this.physicsNotes = physicsNotes;
	}

	public int getChemistryNotes() 
	{
		return chemistryNotes;
	}

	public void setChemistryNotes(int chemistryNotes) 
	{
		this.chemistryNotes = chemistryNotes;
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

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "StudentNotes [id=" + id + ", mathNotes=" + mathNotes + ", physicsNotes=" + physicsNotes
				+ ", chemistryNotes=" + chemistryNotes + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}

	

	

	
	
	
}
