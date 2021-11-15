package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import entity.UserGroup;
import entity.WebGroup;
import entity.WebUser;
import modelDao.WebUserModel;

@Service(value = "webUserService")
public class WebUserService implements UserDetailsService  {
	@Autowired
	private WebUserModel WebUserModel;

	public List<WebUser> getAllWebUsers() {
		// TODO Auto-generated method stub
		return WebUserModel.getAllWebUsers();
	}
	
	public List<WebGroup> getAllWebGroup() {
		// TODO Auto-generated method stub
		return WebUserModel.getAllWebGroup();
	}
	
	public List<WebUser> getAllAdmin() {
		// TODO Auto-generated method stub
		return WebUserModel.getAllAdmin();
	}

	public boolean addWebUser(WebUser WebUser) {
		// TODO Auto-generated method stub
		return WebUserModel.addWebUser(WebUser);
	}
	
	public boolean addUserGroup(UserGroup UserGroup) {
		// TODO Auto-generated method stub
		return WebUserModel.addUserGroup(UserGroup);
	}

	public boolean updateWebUser(WebUser WebUser) {
		// TODO Auto-generated method stub
		return WebUserModel.updateWebUser(WebUser);
	}

	public boolean deleteWebUser(int WebUserId) {
		// TODO Auto-generated method stub
		return WebUserModel.deleteWebUser(WebUserId);
	}

	public WebUser findWebUserById(int WebUserId) {
		// TODO Auto-generated method stub
		return WebUserModel.findWebUserById(WebUserId);
	}
	
	public WebGroup findWebGroupById(int WebUserId) {
		// TODO Auto-generated method stub
		return WebUserModel.findWebGroupById(WebUserId);
	}
	
	public List<String> listStatus(){
		return WebUserModel.listStatus();
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		WebUser webUser = WebUserModel.getUserByUserName(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		
		if (webUser == null) {
			return null;
		} else {
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new User(username, BCrypt.hashpw(webUser.getPassword(), BCrypt.gensalt(12)), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, webUser.getAuthorities());
		}
	}
}
