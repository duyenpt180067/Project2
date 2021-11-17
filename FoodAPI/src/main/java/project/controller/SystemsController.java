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
import project.model.dao.ISystems;
import project.model.entity.Systems;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/system")
public class SystemsController {
	@Autowired
	private ISystems systemDao; 
	
	@GetMapping(value = "/findAllSystem")
	public List<Systems> getAllSystem(){
		return systemDao.findAll();
	}
	
	@GetMapping(value = "/findSystemById/{id}")
	public ResponseEntity<Systems> findSystemById(@PathVariable(value = "id") Integer systemId)
		throws ResourceNotFoundException{
		Systems system = systemDao.findById(systemId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+systemId));
		return ResponseEntity.ok().body(system);
	}
}
