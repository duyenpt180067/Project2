package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IBlog;
import project.model.entity.Blog;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/blog")
public class BlogController {
	@Autowired
	private IBlog blogDao; 
	
	@GetMapping(value = "/findAllBlog")
	public List<Blog> getAllBlog(){
		return blogDao.findAll();
	}
	
	@GetMapping(value = "/findBlogById/{id}")
	public ResponseEntity<Blog> findBlogById(@PathVariable(value = "id") Integer blogId)
		throws ResourceNotFoundException{
		Blog blog = blogDao.findById(blogId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+blogId));
		return ResponseEntity.ok().body(blog);
	}
}
