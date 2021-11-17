package project.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Orders")
public class Orders {

	@Id
	@Column(name = "OrderId")
	@GeneratedValue(generator = "orderId")
	@GenericGenerator(name = "orderId", strategy = "project.property.GenratorOrderId")
	private String orderId;
	@Column(name = "Created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	@Column(name = "addresses")
	private String addresses;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",referencedColumnName = "userId")
	private WebUser user;
	@Column(name="name_receiver")
	private String nameReceiver;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "OrderStatus")
	private String orderStatus;
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> listOD;
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = Date.valueOf(created);
	}
	
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public WebUser getUser() {
		return user;
	}
	public void setUser(WebUser user) {
		this.user = user;
	}
	public String getNameReceiver() {
		return nameReceiver;
	}
	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderDetail> getListOD() {
		return listOD;
	}
	public void setListOD(List<OrderDetail> listOD) {
		this.listOD = listOD;
	}
	public Orders(String orderId, Date created, String addresses, WebUser user, String nameReceiver, String phone, String orderStatus,
			List<OrderDetail> listOD) {
		super();
		this.orderId = orderId;
		this.created = created;
		this.addresses = addresses;
		this.user = user;
		this.nameReceiver = nameReceiver;
		this.phone = phone;
		this.orderStatus = orderStatus;
		this.listOD = listOD;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
