package modelDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Comment;

@Repository
public class CommentModel {
	@Autowired
	private SessionFactory sessionFactory;
	
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> listRating = new ArrayList<Integer>();
	
	public List<Comment> getAllComments() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Comment.class);
		List<Comment> listComments = criteria.list();
		session.getTransaction().commit();
		session.close();
		return listComments;
	}

	public boolean addComment(Comment Comment) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean check = false;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(Comment);
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

	public boolean updateComment(Comment Comment) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(Comment);
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

	public boolean deleteComment(int CommentId) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean check = false;
		try {
			session= sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(findCommentById(CommentId));
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

	public Comment findCommentById(int CommentId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Comment.class);
		criteria.add(Restrictions.eq("commentId", CommentId));
		Comment Comment = (Comment) criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return Comment;
	}
	public boolean findCommentId(int a) {
		for(Integer item: list) {
			if(a == item) {
				return true;
			}
		}
		return false;
	}
	public boolean findRating(int a) {
		for(Integer item: listRating) {
			if(a == item) {
				return true;
			}
		}
		return false;
	}
	public List<Integer> listParentId(){
		if(findCommentId(0) == false) {
			list.add(0);
		}
		for (Comment comment : getAllComments()) {
			if(findCommentId(comment.getCommentId())== false)
				list.add(comment.getCommentId());
		}
		return list;
	}
	public List<Integer> listRate(){
		if(findRating(1) == false) {
			listRating.add(1);
		}
		if(findRating(2) == false) {
			listRating.add(2);
		}
		if(findRating(3) == false) {
			listRating.add(3);
		}
		if(findRating(4) == false) {
			listRating.add(4);
		}
		if(findRating(5) == false) {
			listRating.add(5);
		}
		return listRating;
	}
}

