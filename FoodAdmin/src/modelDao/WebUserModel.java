package modelDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.UserGroup;
import entity.WebGroup;
import entity.WebUser;

@Repository
public class WebUserModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	List<String> listStatus = new ArrayList<String>();
	
	public WebUser getUserByUserName(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(WebUser.class);
		criteria.add(Restrictions.eq("username", username));
		WebUser WebUser = (WebUser) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return WebUser;
	}
	
	public List<WebGroup> getAllWebGroup() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(WebGroup.class);
		List<WebGroup> listWebGroup = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listWebGroup;
	}
	
	public List<WebUser> getAllWebUsers() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(WebUser.class);
		List<WebUser> listWebUsers = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listWebUsers;
	}
	public List<WebUser> getAllAdmin() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(WebUser.class);
		criteria.add(Restrictions.eq("isadmin", true));
		List<WebUser> listWebUsers = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listWebUsers;
	}

	public boolean addWebUser(WebUser WebUser) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(WebUser);
			check = true;
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return check;
	}
	
	public boolean addUserGroup(UserGroup UserGroup) {
		// TODO Auto-generated method stub
		Session session2 = null;
		Boolean check = false;
		try {
			session2 = sessionFactory.openSession();
			session2.getTransaction().begin();
			session2.save(UserGroup);
			check = true;
			session2.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
			session2.getTransaction().rollback();
		} finally {
			session2.close();
		}
		return check;
	}

	public boolean updateWebUser(WebUser WebUser) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(WebUser);
			check = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
			session.getTransaction().rollback();
			// TODO: handle exception
		} finally {
			session.close();
		}
		return check;
	}

	public boolean deleteWebUser(int WebUserId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findWebUserById(WebUserId));
			check = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
			session.getTransaction().rollback();
			// TODO: handle exception
		} finally {
			session.close();
		}
		return check;
	}

	public WebUser findWebUserById(int WebUserId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(WebUser.class);
		criteria.add(Restrictions.eq("userId", WebUserId));
		WebUser WebUser = (WebUser) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return WebUser;
	}
	
	public WebGroup findWebGroupById(int WebGroupId) {
		// TODO Auto-generated method stub
		Session session3 = sessionFactory.openSession();
		session3.getTransaction().begin();
		Criteria criteria = session3.createCriteria(WebGroup.class);
		criteria.add(Restrictions.eq("groupId", WebGroupId));
		WebGroup WebGroup = (WebGroup) criteria.uniqueResult();
		session3.getTransaction().commit();
		session3.close();
		return WebGroup;
	}
	
	public boolean findStatus(String a) {
		for(String item: listStatus) {
			if(a == item) {
				return true;
			}
		}
		return false;
	}
	public List<String> listStatus(){
		if(findStatus("new") == false) {
			listStatus.add("new");
		}
		if(findStatus("active") == false) {
			listStatus.add("active");
		}
		if(findStatus("inactive") == false) {
			listStatus.add("inactive");
		}
		if(findStatus("inactive for a while") == false) {
			listStatus.add("inactive for a while");
		}
		if(findStatus("is locked") == false) {
			listStatus.add("is locked");
		}
		return listStatus;
	}
}