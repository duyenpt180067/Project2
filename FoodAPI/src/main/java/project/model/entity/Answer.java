package project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AnswerId")
	private int answerId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QId", referencedColumnName = "qId")
	private Contact question;
	@Column(name="AnswerContent")
	private String answerContent;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public Contact getQuestion() {
		return question;
	}
	public void setQuestion(Contact question) {
		this.question = question;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Answer(int answerId, Contact question, String answerContent) {
		super();
		this.answerId = answerId;
		this.question = question;
		this.answerContent = answerContent;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
