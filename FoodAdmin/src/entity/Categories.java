package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ca_id")
	private int caId;
	@Column(name = "ca_name")
	private String caName; 
	@Column(name = "parent_id")
	private int parentId;
	@Column(name="descriptions")
	private String descriptions;
	@Column(name = "priorities")
	private int priorities;
	@Column(name = "ca_status")
	private boolean caStatus;
	@Column(name = "imageURL")
	private String imageUrl;
	@OneToMany(mappedBy = "catalog")
	private List<Food> listFood;
	public int getCaId() {
		return caId;
	}
	public void setCaId(int caId) {
		this.caId = caId;
	}
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public int getPriorities() {
		return priorities;
	}
	public void setPriorities(int priorities) {
		this.priorities = priorities;
	}
	public boolean isCaStatus() {
		return caStatus;
	}
	public void setCaStatus(boolean caStatus) {
		this.caStatus = caStatus;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<Food> getListFood() {
		return listFood;
	}
	public void setListFood(List<Food> listFood) {
		this.listFood = listFood;
	}
	public Categories(int caId, String caName,int parentId, String descriptions, int priorities, boolean caStatus,String imageUrl, List<Food> listFood) {
		super();
		this.caId = caId;
		this.caName = caName;
		this.parentId = parentId;
		this.descriptions = descriptions;
		this.priorities = priorities;
		this.caStatus = caStatus;
		this.imageUrl = imageUrl;
		this.listFood = listFood;
	}
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
