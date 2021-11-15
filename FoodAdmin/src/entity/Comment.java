package entity;

import java.sql.Date;

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
@Table(name ="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private WebUser user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "food_id", referencedColumnName = "food_id")
	private Food food;
	@Column(name="content")
	private String content;
	@Column(name="comment_status")
	private boolean commentStatus;
	@Column(name = "created")
	private Date created;
	@Column(name = "parent_id")
	private int parentId;
	@Column(name = "rating")
	private Integer rating;
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public WebUser getUser() {
		return user;
	}
	public void setUser(WebUser user) {
		this.user = user;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(boolean commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Comment(int commentId, WebUser user, Food food, String content, boolean commentStatus, Date created,
			int parentId, Integer rating) {
		super();
		this.commentId = commentId;
		this.user = user;
		this.food = food;
		this.content = content;
		this.commentStatus = commentStatus;
		this.created = created;
		this.parentId = parentId;
		this.rating = rating;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
