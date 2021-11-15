package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Blog;
import modelDao.BlogModel;

@Service
public class BlogService {
	@Autowired
	private BlogModel BlogModel;

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return BlogModel.getAllBlogs();
	}

	public boolean addBlog(Blog Blog) {
		// TODO Auto-generated method stub
		return BlogModel.addBlog(Blog);
	}

	public boolean updateBlog(Blog Blog) {
		// TODO Auto-generated method stub
		return BlogModel.updateBlog(Blog);
	}

	public boolean deleteBlog(int BlogId) {
		// TODO Auto-generated method stub
		return BlogModel.deleteBlog(BlogId);
	}

	public Blog findBlogById(int BlogId) {
		// TODO Auto-generated method stub
		return BlogModel.findBlogById(BlogId);
	}
}

