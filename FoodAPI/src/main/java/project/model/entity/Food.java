package project.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Food")
public class Food {
	
	@Id
	@Column(name = "FoodId")
	private String foodId;
	@JoinColumn(name = "caId", referencedColumnName = "caId")
	@ManyToOne(fetch = FetchType.EAGER)
	private Categories catalog;
	@Column(name = "FoodName")
	private String foodName;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Title")
	private String title;
	@Column(name="ImageURL")
	private String imageURL;
	@Column(name="FoodStatus")
	private boolean foodStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Created")
	private Date created;
	@Column(name = "ReleaseDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;
	@Column(name = "Discount")
	private float discount;
	@Column(name= "FoodView")
	private int foodView;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<FoodDetail> listFoodDetail;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<ImageFood> listImageFood;
	@OneToMany(mappedBy = "food")
	@JsonIgnore
	private List<Favorite> listFavorite;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<Comment> listComment;
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public Categories getCatalog() {
		return catalog;
	}
	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(boolean foodStatus) {
		this.foodStatus = foodStatus;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = Date.valueOf(releaseDate);
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getFoodView() {
		return foodView;
	}
	public void setFoodView(int foodView) {
		this.foodView = foodView;
	}
	public List<FoodDetail> getListFoodDetail() {
		return listFoodDetail;
	}
	public void setListFoodDetail(List<FoodDetail> listFoodDetail) {
		this.listFoodDetail = listFoodDetail;
	}
	public List<ImageFood> getListImageFood() {
		return listImageFood;
	}
	public void setListImageFood(List<ImageFood> listImageFood) {
		this.listImageFood = listImageFood;
	}
	public List<Favorite> getListFavorite() {
		return listFavorite;
	}
	public void setListFavorite(List<Favorite> listFavorite) {
		this.listFavorite = listFavorite;
	}
	public List<Comment> getListComment() {
		return listComment;
	}
	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}
	public Food(String foodId, Categories catalog, String foodName, String descriptions, String title, String imageURL,
			boolean foodStatus, Date created, Date releaseDate, float discount, int foodView,
			List<FoodDetail> listFoodDetail, List<ImageFood> listImageFood, List<Favorite> listFavorite,
			List<Comment> listComment) {
		super();
		this.foodId = foodId;
		this.catalog = catalog;
		this.foodName = foodName;
		this.descriptions = descriptions;
		this.title = title;
		this.imageURL = imageURL;
		this.foodStatus = foodStatus;
		this.created = created;
		this.releaseDate = releaseDate;
		this.discount = discount;
		this.foodView = foodView;
		this.listFoodDetail = listFoodDetail;
		this.listImageFood = listImageFood;
		this.listFavorite = listFavorite;
		this.listComment = listComment;
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

}
