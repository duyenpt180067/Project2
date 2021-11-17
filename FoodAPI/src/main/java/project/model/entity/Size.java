package project.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Size")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SizeId")
	private int sizeId;
	@Column(name="SizeName")
	private String sizeName;
	@Column(name="SizeStatus")
	private boolean sizeStatus;
	@JsonIgnore
	@OneToMany(mappedBy = "size")
	private List<FoodDetail> listFoodDetail;
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public boolean isSizeStatus() {
		return sizeStatus;
	}
	public void setSizeStatus(boolean sizeStatus) {
		this.sizeStatus = sizeStatus;
	}
	public List<FoodDetail> getListFoodDetail() {
		return listFoodDetail;
	}
	public void setListFoodDetail(List<FoodDetail> listFoodDetail) {
		this.listFoodDetail = listFoodDetail;
	}
	public Size(int sizeId, String sizeName, boolean sizeStatus, List<FoodDetail> listFoodDetail) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.sizeStatus = sizeStatus;
		this.listFoodDetail = listFoodDetail;
	}
	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
