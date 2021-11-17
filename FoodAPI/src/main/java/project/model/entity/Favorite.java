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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Favorite")
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FavoriteId")
	private int favoriteId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FoodId", referencedColumnName = "foodId")
	private Food food;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private WebUser user;
	@Column(name = "Likes")
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
	public Favorite(int favoriteId, Food food, WebUser user, int likes) {
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
