package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Comment;
import modelDao.CommentModel;

@Service
public class CommentService {
	@Autowired
	private CommentModel CommentModel;

	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return CommentModel.getAllComments();
	}

	public boolean addComment(Comment Comment) {
		// TODO Auto-generated method stub
		return CommentModel.addComment(Comment);
	}

	public boolean updateComment(Comment Comment) {
		// TODO Auto-generated method stub
		return CommentModel.updateComment(Comment);
	}

	public boolean deleteComment(int CommentId) {
		// TODO Auto-generated method stub
		return CommentModel.deleteComment(CommentId);
	}

	public Comment findCommentById(int CommentId) {
		// TODO Auto-generated method stub
		return CommentModel.findCommentById(CommentId);
	}
	public List<Integer> listParentId(){
		return CommentModel.listParentId();
	}
	public List<Integer> listRating(){
		return CommentModel.listRate();
	}
}

