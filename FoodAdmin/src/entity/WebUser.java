package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name ="web_user")
public class WebUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name ="user_name")
	private String username;
	@Column(name ="pass")
	private String password;
	@Column(name="phone")
	private String phone;
	@Column(name="addresses")
	private String addresses;
	@Column (name="permission")
	private boolean permission;
	@Column(name="user_status")
	private String userStatus;
	@Column (name="is_admin")
	private boolean isadmin;
	@OneToMany( mappedBy = "user")
	private List<Comment> listComment;
	@OneToMany(mappedBy = "user")
	private List<Favorite> listFavorite;
	@OneToMany(mappedBy = "user")
	private List<Orders> listOrder;
	@OneToMany(mappedBy = "user")
	private List<Blog> listBlog;
	@OneToMany(mappedBy = "webUser", fetch = FetchType.EAGER)
	private List<UserGroup> listUserGroup = new ArrayList<UserGroup>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public WebUser(int userId, String username, String password, String phone, String addresses, boolean permission,
			String userStatus, boolean isadmin, List<Comment> listComment, List<Favorite> listFavorite,
			List<Orders> listOrder, List<Blog> listBlog, List<UserGroup> listUserGroup) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
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
	@Transient
	public List<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserGroup userGroup : this.listUserGroup) {
			authorities.add(new SimpleGrantedAuthority(userGroup.getWebGroup().getGroupName()));
		}
		return authorities;
	}
}
