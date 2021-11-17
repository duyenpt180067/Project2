package project.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "FAQ")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FaqId")
	private int faqId;
	@Column(name="FaqQuestion")
	private String faqQuestion;
	@Column(name="FaqAnswer")
	private String faqAnswer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Created")
	private Date created;
	@Column(name="Priorities")
	private int priorities;
	public int getFaqId() {
		return faqId;
	}
	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	public int getPriorities() {
		return priorities;
	}
	public void setPriorities(int priorities) {
		this.priorities = priorities;
	}
	public Faq(int faqId, String faqQuestion, String faqAnswer, Date created, int priorities) {
		super();
		this.faqId = faqId;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
		this.created = created;
		this.priorities = priorities;
	}
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
