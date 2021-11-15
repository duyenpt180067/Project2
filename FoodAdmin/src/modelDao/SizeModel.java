package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Size;

@Repository
public class SizeModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Size> getAllSizes() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Size.class);
		List<Size> listSizes = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listSizes;
	}

	public boolean addSize(Size Size) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Size);
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

	public boolean updateSize(Size Size) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Size);
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

	public boolean deleteSize(int SizeId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findSizeById(SizeId));
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

	public Size findSizeById(int SizeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Size.class);
		criteria.add(Restrictions.eq("sizeId", SizeId));
		Size Size = (Size) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Size;
	}
}
