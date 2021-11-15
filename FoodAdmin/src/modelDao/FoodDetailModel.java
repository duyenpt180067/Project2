package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.FoodDetail;

@Repository
public class FoodDetailModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<FoodDetail> getAllFoodDetails() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(FoodDetail.class);
		List<FoodDetail> listFoodDetails = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listFoodDetails;
	}

	public boolean addFoodDetail(FoodDetail FoodDetail) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(FoodDetail);
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

	public boolean updateFoodDetail(FoodDetail FoodDetail) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(FoodDetail);
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

	public boolean deleteFoodDetail(int FoodDetailId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findFoodDetailById(FoodDetailId));
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

	public FoodDetail findFoodDetailById(int FoodDetailId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(FoodDetail.class);
		criteria.add(Restrictions.eq("fdId", FoodDetailId));
		FoodDetail FoodDetail = (FoodDetail) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return FoodDetail;
	}
}

