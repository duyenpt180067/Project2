package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Food;
import entity.FoodDetail;

@Repository
public class FoodModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Food> getAllFoods() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Food.class);
		List<Food> listFoods = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listFoods;
	}

	public boolean addFood(Food Food) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Food);
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

	public boolean updateFood(Food Food) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Food);
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

	public boolean deleteFood(String FoodId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findFoodById(FoodId));
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

	public Food findFoodById(String FoodId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Food.class);
		criteria.add(Restrictions.eq("foodId", FoodId));
		Food Food = (Food) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Food;
	}
	
	public List<FoodDetail> listFoodDetail(Food food){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(FoodDetail.class);
		criteria.add(Restrictions.eq("food", food));
		List<FoodDetail> listFoodDetail = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listFoodDetail;
	}
}

