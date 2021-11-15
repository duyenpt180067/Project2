package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Favorite;

@Repository
public class FavoriteModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Favorite> getAllFavorites() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Favorite.class);
		List<Favorite> listFavorites = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listFavorites;
	}

	public boolean addFavorite(Favorite Favorite) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Favorite);
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

	public boolean updateFavorite(Favorite Favorite) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Favorite);
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

	public boolean deleteFavorite(int FavoriteId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findFavoriteById(FavoriteId));
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

	public Favorite findFavoriteById(int FavoriteId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Favorite.class);
		criteria.add(Restrictions.eq("favoriteId", FavoriteId));
		Favorite Favorite = (Favorite) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Favorite;
	}
}

