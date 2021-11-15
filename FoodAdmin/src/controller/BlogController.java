package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Blog;
import entity.WebUser;
import service.BlogService;
import service.WebUserService;

@Controller
@RequestMapping(value = "/AdminController/blog")
public class BlogController {
	
	@Autowired
	private BlogService BlogService;
	@Autowired
	private WebUserService WebUserService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("blog/index");
		List<Blog> listBlogs = BlogService.getAllBlogs();
		mAndView.addObject("listBlogs", listBlogs);
		List<WebUser> listWebUsers = WebUserService.getAllAdmin();
		mAndView.addObject("listWebUsers", listWebUsers);
		return mAndView;
	}

	@RequestMapping(value = "initAddBlog.htm")
	public ModelAndView addBlog() {
		ModelAndView mAndView = new ModelAndView("blog/NewBlog");
		Blog Blog = new Blog();
		List<WebUser> listWebUsers = WebUserService.getAllAdmin();
		mAndView.addObject("listWebUsers", listWebUsers);
		mAndView.addObject("BlogNew", Blog);
		return mAndView;
	}
	
	@RequestMapping(value = "addBlog.htm")
	public String addNewBlog(Blog BlogNew) {
		boolean check = BlogService.addBlog(BlogNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "initUpdateBlog.htm")
	public ModelAndView updateBlog(int blogId) {
		ModelAndView mAndView = new ModelAndView("blog/UpdateBlog");
		List<WebUser> listWebUsers = WebUserService.getAllAdmin();
		mAndView.addObject("listWebUsers", listWebUsers);
		Blog Blog = BlogService.findBlogById(blogId);
		mAndView.addObject("BlogUp", Blog);
		return mAndView;
	}
	
	@RequestMapping(value = "updateBlog.htm")
	public String updateBlog(Blog BlogUp) {
		boolean check = BlogService.updateBlog(BlogUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteBlog.htm")
	public String deleteBlog(int blogId) {
		boolean check = BlogService.deleteBlog(blogId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}
