package project.model.entity;

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
@Table(name ="Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CommentId")
	private int favoriteId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private WebUser user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;
	@Column(name="Content")
	private String content;
	@Column(name="CommentStatus")
	private boolean commentStatus;
	@Column(name = "Created")
	private Date created;
	@Column(name = "ParentId")
	private int parentId;
	@Column(name = "rating")
	private Integer rating;
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
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
	public Comment(int favoriteId, WebUser user, Food food, String content, Date created,
			Integer rating) {
		super();
		this.favoriteId = favoriteId;
		this.user = user;
		this.food = food;
		this.content = content;
		this.commentStatus = true;
		this.created = created;
		this.parentId = 0;
		this.rating = rating;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
