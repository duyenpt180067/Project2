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
@Table(name = "bonus")
public class Bonus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bonus_id")
	private int bonusId;
	@Column(name="bonus_name")
	private String bonusName;
	@Column(name="bonus_pice")
	private int bonusPrice;
	@Column(name="bonus_image")
	private String bonusImage;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fd_id", referencedColumnName = "fd_id")
	private FoodDetail foodDetail;
	public int getBonusId() {
		return bonusId;
	}
	public void setBonusId(int bonusId) {
		this.bonusId = bonusId;
	}
	public String getBonusName() {
		return bonusName;
	}
	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}
	public int getBonusPrice() {
		return bonusPrice;
	}
	public void setBonusPrice(int bonusPrice) {
		this.bonusPrice = bonusPrice;
	}
	public String getBonusImage() {
		return bonusImage;
	}
	public void setBonusImage(String bonusImage) {
		this.bonusImage = bonusImage;
	}
	public FoodDetail getFoodDetail() {
		return foodDetail;
	}
	public void setFoodDetail(FoodDetail foodDetail) {
		this.foodDetail = foodDetail;
	}
	
	public Bonus(int bonusId, String bonusName, int bonusPrice, String bonusImage, FoodDetail foodDetail) {
		super();
		this.bonusId = bonusId;
		this.bonusName = bonusName;
		this.bonusPrice = bonusPrice;
		this.bonusImage = bonusImage;
		this.foodDetail = foodDetail;
	}
	public Bonus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
