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
import project.model.dao.IContact;
import project.model.entity.Contact;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/contact")
public class ContactController {
	@Autowired
	private IContact questionDao; 
	
	@GetMapping(value = "/findAllQuestion")
	public List<Contact> getAllQuestion(){
		return questionDao.findAll();
	}
	
	@GetMapping(value = "/findQuestionById/{id}")
	public ResponseEntity<Contact> findQuestionById(@PathVariable(value = "id") Integer questionId)
		throws ResourceNotFoundException{
		Contact question = questionDao.findById(questionId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+questionId));
		return ResponseEntity.ok().body(question);
	}
	@PostMapping(value = "/save")
	public Contact createNewCategory(@RequestBody Contact order) {
		return questionDao.save(order);
	}
}
