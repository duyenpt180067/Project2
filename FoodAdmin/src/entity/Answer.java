package entity;

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
@Table(name ="answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "qid", referencedColumnName = "qid")
	private Contact question;
	@Column(name="answer_content")
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
