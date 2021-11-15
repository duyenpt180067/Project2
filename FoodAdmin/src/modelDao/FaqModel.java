package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Faq;

@Repository
public class FaqModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Faq> getAllFaqs() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Faq.class);
		List<Faq> listFaqs = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listFaqs;
	}

	public boolean addFaq(Faq Faq) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Faq);
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

	public boolean updateFaq(Faq Faq) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Faq);
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

	public boolean deleteFaq(int FaqId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findFaqById(FaqId));
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

	public Faq findFaqById(int FaqId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Faq.class);
		criteria.add(Restrictions.eq("faqId", FaqId));
		Faq Faq = (Faq) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Faq;
	}
}

