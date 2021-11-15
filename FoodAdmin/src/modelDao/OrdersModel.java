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
import entity.OrderDetail;
import entity.Orders;

@Repository
public class OrdersModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Orders> getAllOrderss() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Orders.class);
		List<Orders> listOrderss = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listOrderss;
	}

	public boolean addOrders(Orders Orders) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Orders);
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

	public boolean updateOrders(Orders Orders) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Orders);
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

	public boolean deleteOrders(String OrdersId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findOrdersById(OrdersId));
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

	public Orders findOrdersById(String OrdersId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("orderId", OrdersId));
		Orders Orders = (Orders) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Orders;
	}
	public List<Orders> listOrderChoXuLy(){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("orderStatus","cho xu ly"));
		//criteria.add(Restrictions.eq("orderStatus","dang van chuyen"));
		List<Orders> listOrderss = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listOrderss;
	}
	
	public List<OrderDetail> listOrderDetail(Orders order){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(OrderDetail.class);
		criteria.add(Restrictions.eq("order", order));
		List<OrderDetail> listOrderDetail = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listOrderDetail;
	}
}
