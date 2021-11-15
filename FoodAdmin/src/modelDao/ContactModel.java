package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Contact;

@Repository
public class ContactModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Contact> getAllQuestions() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Contact.class);
		List<Contact> listQuestions = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listQuestions;
	}

	public boolean addQuestion(Contact Question) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Question);
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

	public boolean updateQuestion(Contact Question) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Question);
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

	public boolean deleteQuestion(int QuestionId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findQuestionById(QuestionId));
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

	public Contact findQuestionById(int QuestionId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.eq("qId", QuestionId));
		Contact Question = (Contact) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Question;
	}
}

