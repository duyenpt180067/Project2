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
@Table(name = "Bonus")
public class Bonus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BonusId")
	private int bonusId;
	@Column(name="BonusName")
	private String bonusName;
	@Column(name="BonusPice")
	private int bonusPrice;
	@Column(name="BonusImage")
	private String bonusImage;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FdId", referencedColumnName = "fdId")
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
