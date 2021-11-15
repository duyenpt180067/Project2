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
@Table(name = "user_group")
public class UserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_group_id")
	private int userGroupId;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private WebUser webUser;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private WebGroup webGroup;

	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroup(int userGroupId, WebUser webUser, WebGroup webGroup) {
		super();
		this.userGroupId = userGroupId;
		this.webUser = webUser;
		this.webGroup = webGroup;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}

	public WebGroup getWebGroup() {
		return webGroup;
	}

	public void setWebGroup(WebGroup webGroup) {
		this.webGroup = webGroup;
	}

}
