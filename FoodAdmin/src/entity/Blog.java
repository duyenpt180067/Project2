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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int blogId;
	@Column(name = "blog_name")
	private String blogName;
	@Column(name = "title")
	private String title;
	@Column(name = "descriptions")
	private String descriptions;
	@Column(name = "created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private WebUser user;
	@Column(name="imageurl")
	private String imageURL;
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	public WebUser getUser() {
		return user;
	}
	public void setUser(WebUser user) {
		this.user = user;
	}
	
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public Blog(String blogName,int blogId, String title,String imageURL, String descriptions, Date created, WebUser user) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.title = title;
		this.descriptions = descriptions;
		this.created = created;
		this.user = user;
		this.imageURL = imageURL;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
