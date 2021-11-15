package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="qid")
	private int qId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="subject")
	private String subject;
	@Column(name="qcontent")
	private String qContent;
	@Column(name="qstatus")
	private boolean qStatus;
	@OneToMany(mappedBy = "question")
	private List<Answer> listAswer;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public boolean isqStatus() {
		return qStatus;
	}
	public void setqStatus(boolean qStatus) {
		this.qStatus = qStatus;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Answer> getListAswer() {
		return listAswer;
	}
	public void setListAswer(List<Answer> listAswer) {
		this.listAswer = listAswer;
	}
	public Contact(int qId, String name, String email, String subject, String qContent, List<Answer> listAswer) {
		super();
		this.qId = qId;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.qContent = qContent;
		this.qStatus = false;
		this.listAswer = listAswer;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
