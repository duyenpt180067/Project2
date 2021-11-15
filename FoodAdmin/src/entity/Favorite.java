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
@Table(name ="favorite")
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_id")
	private int favoriteId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "food_id", referencedColumnName = "food_id")
	private Food food;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private WebUser user;
	@Column(name = "likes")
	private int likes;
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public WebUser getUser() {
		return user;
	}
	public void setUser(WebUser user) {
		this.user = user;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Favorite(int favoriteId, Food food, WebUser user,int likes) {
		super();
		this.favoriteId = favoriteId;
		this.food = food;
		this.user = user;
		this.likes = likes;
	}
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
