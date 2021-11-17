package project.model.entity;

import java.util.ArrayList;
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
@Table(name ="WebUser")
public class WebUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int userId;
	@Column(name ="UserName")
	private String userName;
	@Column(name ="Pass")
	private String pass;
	@Column(name="Phone")
	private String phone;
	@Column(name="Addresses")
	private String addresses;
	@Column (name="Permission")
	private boolean permission;
	@Column(name="UserStatus")
	private String userStatus;
	@Column (name="isAdmin")
	private boolean isadmin;
	@OneToMany( mappedBy = "user")
	@JsonIgnore
	private List<Comment> listComment;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Favorite> listFavorite;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Orders> listOrder;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Blog> listBlog;
	@JsonIgnore
	@OneToMany(mappedBy = "webUser")
	private List<UserGroup> listUserGroup = new ArrayList<UserGroup>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public boolean isPermission() {
		return permission;
	}
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	public List<Comment> getListComment() {
		return listComment;
	}
	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}
	public List<Favorite> getListFavorite() {
		return listFavorite;
	}
	public void setListFavorite(List<Favorite> listFavorite) {
		this.listFavorite = listFavorite;
	}
	public List<Orders> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<Orders> listOrder) {
		this.listOrder = listOrder;
	}
	public List<Blog> getListBlog() {
		return listBlog;
	}
	public void setListBlog(List<Blog> listBlog) {
		this.listBlog = listBlog;
	}
	public List<UserGroup> getListUserGroup() {
		return listUserGroup;
	}
	public void setListUserGroup(List<UserGroup> listUserGroup) {
		this.listUserGroup = listUserGroup;
	}
	
	public WebUser(int userId, String userName, String pass, String phone, String addresses, boolean permission,
			String userStatus, boolean isadmin, List<Comment> listComment, List<Favorite> listFavorite,
			List<Orders> listOrder, List<Blog> listBlog, List<UserGroup> listUserGroup) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pass = pass;
		this.phone = phone;
		this.addresses = addresses;
		this.permission = permission;
		this.userStatus = userStatus;
		this.isadmin = isadmin;
		this.listComment = listComment;
		this.listFavorite = listFavorite;
		this.listOrder = listOrder;
		this.listBlog = listBlog;
		this.listUserGroup = listUserGroup;
	}
	public WebUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
