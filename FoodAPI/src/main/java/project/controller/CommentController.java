package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IComment;
import project.model.entity.Comment;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/comment")
public class CommentController {
	@Autowired
	private IComment commentDao; 
	
	@GetMapping(value = "/findAllComment")
	public List<Comment> getAllComment(){
		return commentDao.findAll();
	}
	
	@GetMapping(value = "/findCommentById/{id}")
	public ResponseEntity<Comment> findCommentById(@PathVariable(value = "id") Integer commentId)
		throws ResourceNotFoundException{
		Comment comment = commentDao.findById(commentId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+commentId));
		return ResponseEntity.ok().body(comment);
	}
	@PostMapping(value = "/save")
	public Comment createNewCategory(@RequestBody Comment comment) {
		return commentDao.save(comment);
	}
}
