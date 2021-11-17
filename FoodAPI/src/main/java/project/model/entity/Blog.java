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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BlogId")
	private int blogId;
	@Column(name = "BlogName")
	private String blogName;
	@Column(name = "Title")
	private String title;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Imageurl")
	private String imageurl;
	@Column(name = "Created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	@Column(name = "Note")
	private String note;
	@Column(name = "Conclude")
	private String conclude;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	private WebUser user;
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getConclude() {
		return conclude;
	}
	public void setConclude(String conclude) {
		this.conclude = conclude;
	}
	public WebUser getUser() {
		return user;
	}
	public void setUser(WebUser user) {
		this.user = user;
	}
	public Blog(int blogId,String blogName, String title, String descriptions,String imageurl, Date created,String note, String conclude, WebUser user) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.title = title;
		this.descriptions = descriptions;
		this.imageurl = imageurl;
		this.created = created;
		this.user = user;
		this.note = note;
		this.conclude = conclude;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
