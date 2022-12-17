package hibernate.tutorial.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_reviews")
public class StudentReview {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="student_comment")
	private String studentComment;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	public StudentReview() {
		
	}

	public StudentReview(String studentComment, Date created_at, Date updated_at) {
		
		this.studentComment = studentComment;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentComment() {
		return studentComment;
	}

	public void setStudentComment(String studentComment) {
		this.studentComment = studentComment;
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

	@Override
	public String toString() {
		return "StudentReview [id=" + id + ", studentComment=" + studentComment + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	
	
}
