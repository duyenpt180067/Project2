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
@Table(name = "ImageFood")
public class ImageFood {
	
	@Id
	@Column(name="ImageId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FoodId", referencedColumnName = "foodId")
	private Food food;
	@Column(name = "ImageURL")
	private String imageURL;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public ImageFood(int imageId, Food food, String imageURL) {
		super();
		this.imageId = imageId;
		this.food = food;
		this.imageURL = imageURL;
	}
	public ImageFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
