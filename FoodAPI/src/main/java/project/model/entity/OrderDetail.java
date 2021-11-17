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
@Table(name ="OrderDetail")
public class OrderDetail {
	@Id
	@Column(name = "OdId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int odId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OrderId", referencedColumnName = "orderId")
	private Orders order;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FdId", referencedColumnName = "fdId")
	private FoodDetail foodDetail;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Price")
	private float price;
	public int getOdId() {
		return odId;
	}
	public void setOdId(int odId) {
		this.odId = odId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public FoodDetail getFoodDetail() {
		return foodDetail;
	}
	public void setFoodDetail(FoodDetail foodDetail) {
		this.foodDetail = foodDetail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public OrderDetail(int odId, Orders order, FoodDetail foodDetail, int quantity, float price) {
		super();
		this.odId = odId;
		this.order = order;
		this.foodDetail = foodDetail;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
