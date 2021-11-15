package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Comment;
import entity.Food;
import entity.WebUser;
import service.CommentService;
import service.FoodService;
import service.WebUserService;

@Controller
@RequestMapping(value = "/AdminController/comment")
public class CommentController {
	
	@Autowired
	private CommentService CommentService;
	@Autowired
	private WebUserService WebUserService;
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("comment/index");
		List<Comment> listComments = CommentService.getAllComments();
		mAndView.addObject("listComments", listComments);
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		List<Food> listFoods = foodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		return mAndView;
	}

	@RequestMapping(value = "/initAddComment.htm")
	public ModelAndView addComment() {
		ModelAndView mAndView = new ModelAndView("comment/NewComment");
		Comment Comment = new Comment();
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		List<Food> listFoods = foodService.getAllFoods();
		List<Integer> listParentId = CommentService.listParentId();
		List<Integer> listRating = CommentService.listRating();
		mAndView.addObject("listRating", listRating);
		mAndView.addObject("listParentId", listParentId);
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("listWebUsers", listWebUsers);
		mAndView.addObject("CommentNew", Comment);
		return mAndView;
	}
	
	@RequestMapping(value = "addComment.htm")
	public String addNewComment(Comment CommentNew) {
		boolean check = CommentService.addComment(CommentNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateComment.htm")
	public ModelAndView updateComment(int commentId) {
		ModelAndView mAndView = new ModelAndView("comment/UpdateComment");
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		List<Food> listFoods = foodService.getAllFoods();
		List<Integer> listParentId = CommentService.listParentId();
		List<Integer> listRating = CommentService.listRating();
		mAndView.addObject("listRating", listRating);
		mAndView.addObject("listParentId", listParentId);
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("listWebUsers", listWebUsers);
		Comment Comment = CommentService.findCommentById(commentId);
		mAndView.addObject("CommentUp", Comment);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateComment.htm")
	public String updateComment(Comment CommentUp) {
		boolean check = CommentService.updateComment(CommentUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteComment.htm")
	public String deleteComment(int commentId) {
		boolean check = CommentService.deleteComment(commentId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}

