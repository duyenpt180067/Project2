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
import project.model.dao.IAnswer;
import project.model.entity.Answer;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {
	@Autowired
	private IAnswer answerDao; 
	
	@GetMapping(value = "/findAllAnswer")
	public List<Answer> getAllAnswer(){
		return answerDao.findAll();
	}
	
	@GetMapping(value = "/findAnswerById/{id}")
	public ResponseEntity<Answer> findAnswerById(@PathVariable(value = "id") Integer answerId)
		throws ResourceNotFoundException{
		Answer answer = answerDao.findById(answerId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+answerId));
		return ResponseEntity.ok().body(answer);
	}
}