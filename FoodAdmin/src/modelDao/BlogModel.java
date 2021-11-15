package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Blog;

@Repository
public class BlogModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Blog> getAllBlogs() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Blog.class);
		List<Blog> listBlogs = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listBlogs;
	}

	public boolean addBlog(Blog Blog) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Blog);
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

	public boolean updateBlog(Blog Blog) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Blog);
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

	public boolean deleteBlog(int BlogId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findBlogById(BlogId));
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

	public Blog findBlogById(int BlogId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Blog.class);
		criteria.add(Restrictions.eq("blogId", BlogId));
		Blog Blog = (Blog) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Blog;
	}
}

