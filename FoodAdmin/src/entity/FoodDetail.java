package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="food_detail")
public class FoodDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fd_id")
	private int fdId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="food_id", referencedColumnName = "food_id")
	private Food food;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="size_id",referencedColumnName = "size_id")
	private Size size;
	@Column(name = "price")
	private int price;
	@Column(name= "fd_status")
	private String fdStatus;
	@Column(name = "quantity")
	private int quantity;
	@OneToMany(mappedBy = "foodDetail")
	private List<OrderDetail> listOrderDetail;
	@OneToMany(mappedBy = "foodDetail")
	private List<Bonus> listBonus;
	public int getFdId() {
		return fdId;
	}
	public void setFdId(int fdId) {
		this.fdId = fdId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFdStatus() {
		return fdStatus;
	}
	public void setFdStatus(String fdStatus) {
		this.fdStatus = fdStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}
	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	public List<Bonus> getListBonus() {
		return listBonus;
	}
	public void setListBonus(List<Bonus> listBonus) {
		this.listBonus = listBonus;
	}
	public FoodDetail(int fdId, Food food, Size size, int price, String fdStatus, int quantity, List<OrderDetail> listOrderDetail, List<Bonus> listBonus) {
		super();
		this.fdId = fdId;
		this.food = food;
		this.size = size;
		this.price = price;
		this.fdStatus = fdStatus;
		this.quantity = quantity;
		this.listOrderDetail = listOrderDetail;
		this.listBonus = listBonus;
	}
	public FoodDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
