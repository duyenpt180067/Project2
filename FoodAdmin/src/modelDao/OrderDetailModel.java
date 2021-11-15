package modelDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.OrderDetail;

@Repository
public class OrderDetailModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<OrderDetail> getAllOrderDetails() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(OrderDetail.class);
		List<OrderDetail> listOrderDetails = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listOrderDetails;
	}

	public boolean addOrderDetail(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(OrderDetail);
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

	public boolean updateOrderDetail(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(OrderDetail);
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

	public boolean deleteOrderDetail(int OrderDetailId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findOrderDetailById(OrderDetailId));
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

	public OrderDetail findOrderDetailById(int OrderDetailId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(OrderDetail.class);
		criteria.add(Restrictions.eq("odId", OrderDetailId));
		OrderDetail OrderDetail = (OrderDetail) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return OrderDetail;
	}
	public List<OrderDetail> listOD(String OrderId){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(OrderDetail.class);
		criteria.add(Restrictions.eq("order.orderId", OrderId));
		List<OrderDetail> listOrderDetails = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listOrderDetails;
	}
}

